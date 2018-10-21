package org.landy.business.identify.component.factory;

import org.apache.commons.collections.CollectionUtils;
import org.landy.business.enums.WorkflowEnum;
import org.landy.business.identify.component.annotation.KeyIdentificationStrategy;
import org.landy.business.identify.component.domain.IdentifyCriterion;
import org.landy.business.identify.component.enums.IdentificationResultType;
import org.landy.business.identify.component.primary.DefaultKeyIdentificationChain;
import org.landy.business.identify.component.primary.KeyIdentification;
import org.landy.utils.PackageUtil;
import org.landy.web.utils.ApplicationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 组合主键查询功能操作工厂类，省去模板类还需要子类实现，造成Handler类膨胀的因素
 * 利用注解把不同的业务流程的KeyIdentification实现动态加入到identificationHandlerMap中
 * @author landyl
 * @create 11:04 AM 09/06/2018
 * @see org.landy.business.identify.component.primary.KeyIdentification
 * @see KeyIdentificationStrategy
 */
@Component
public class KeyIdentificationFactory implements ApplicationListener<ContextRefreshedEvent> {
    protected static Logger LOGGER = LoggerFactory.getLogger(KeyIdentificationFactory.class);

    private ClassLoader classLoader = getClass().getClassLoader();

    @Autowired
    protected DefaultKeyIdentificationChain defaultKeyIdentificationChain;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            LOGGER.info("Start to add the identification into current handler,base packages contains:{}",this.getBasePackages());
            this.addIdentifications();
        }
    }

    public IdentificationResultType identify(IdentifyCriterion identifyCriterion,WorkflowEnum workflowId) {
        //must set the current workflowId
        defaultKeyIdentificationChain.doClearIdentificationIndex(workflowId);
        return defaultKeyIdentificationChain.doIdentify(identifyCriterion,workflowId);
    }

    private void addIdentifications() {
        defaultKeyIdentificationChain.clearIdentifications();

        List<Class<? extends KeyIdentification>> identifications = getIdentifications();

        //按优先级排序
        KeyIdentificationComparator comparator = new KeyIdentificationComparator();
        Collections.sort(identifications,comparator);


        identifications.forEach((v) -> {
            Optional<KeyIdentificationStrategy> strategyOptional = this.getPrimaryKeyIdentificationStrategy(v);
            String simpleName = v.getSimpleName();
            if(strategyOptional.isPresent()) {
                KeyIdentificationStrategy strategy = strategyOptional.get();
                String beanName = strategy.beanName();
                //业务流程类型
                WorkflowEnum workflowId = strategy.workflowId();

                KeyIdentificationStrategy priority = getPrimaryKeyIdentificationStrategy(v).get();

                LOGGER.info("To add identification:{},spring bean name is:{},the identify priority is:{},workflowId:{}",simpleName,beanName,priority.priority(),workflowId.name());

                KeyIdentification instance = ApplicationUtil.getApplicationContext().getBean(beanName,v);

                defaultKeyIdentificationChain.addIdentification(instance,workflowId);

            }
        });

    }

    private Optional<KeyIdentificationStrategy> getPrimaryKeyIdentificationStrategy(Class<? extends KeyIdentification> clazz) {
        Optional<KeyIdentificationStrategy> strategy;
        //find the annotation object from the class type
        boolean isExist = clazz.isAnnotationPresent(KeyIdentificationStrategy.class);
        if(isExist){
            KeyIdentificationStrategy v = clazz.getAnnotation(KeyIdentificationStrategy.class);
            strategy = Optional.of(v);
            return strategy;
        }
        return Optional.empty();
    }

    private List<Class<? extends KeyIdentification>> getIdentifications() {
        Set<String> packageNames = this.getBasePackages();
        List<Class<? extends KeyIdentification>> identifications = new ArrayList<>();
        if(packageNames != null) {
            packageNames.forEach((packageName) -> identifications.addAll(getIdentifications(packageName)));
        }
        return identifications;
    }

    private List<Class<? extends KeyIdentification>> getIdentifications(String packageName) {
        Set<Class<?>> classes = PackageUtil.getClzFromPkg(packageName);

        Class<KeyIdentification> identificationClazz;
        try {
            identificationClazz = (Class<KeyIdentification>) classLoader.loadClass(KeyIdentification.class.getName());//
        } catch (ClassNotFoundException e1) {
            throw new RuntimeException("The KeyIdentification interface has not found");
        }

        if(CollectionUtils.isNotEmpty(classes)) {
            List<Class<? extends KeyIdentification>> identifications = new ArrayList<>(classes.size());
            classes.forEach(clazz->{
                if (KeyIdentification.class.isAssignableFrom(clazz) && clazz != identificationClazz) {
                    Set<Class> excludeClasses = this.excludeClasses();
                    if(excludeClasses!= null && !excludeClasses.contains(clazz)) {
                        identifications.add((Class<? extends KeyIdentification>) clazz);
                    } else {
                        if(excludeClasses == null || excludeClasses.isEmpty()) {
                            identifications.add((Class<? extends KeyIdentification>) clazz);
                        }
                    }
                }
            });
            return identifications;
        }

        return new ArrayList<>(0);
    }

    /**
     * the package need to be added the ApplicationStatusUpdateRules
     * @return
     */
    private Set<String> getBasePackages() {
        Set<String> packages = new HashSet<>();
        packages.add("org.landy.business.identify");
        return packages;
    }

    /**
     * the classes need to be excluded
     * @return
     */
    private Set<Class> excludeClasses() {
        return null;
    }

    /**
     * define a comparator of the KeyIdentification object through the priority of the IdentifyPriority for sort purpose.
     * @see KeyIdentificationStrategy
     */
    private class KeyIdentificationComparator implements Comparator {
        @Override
        public int compare(Object objClass1, Object objClass2) {
            if(objClass1 != null && objClass2 != null) {
                Optional<KeyIdentificationStrategy> strategyOptional1 = getPrimaryKeyIdentificationStrategy((Class)objClass1);
                Optional<KeyIdentificationStrategy> strategyOptional2 = getPrimaryKeyIdentificationStrategy((Class)objClass2);

                KeyIdentificationStrategy ip1 = strategyOptional1.get();
                KeyIdentificationStrategy ip2 = strategyOptional2.get();

                Integer priority1 = ip1.priority();
                Integer priority2 = ip2.priority();

                WorkflowEnum workflow1 = ip1.workflowId();
                WorkflowEnum workflow2 = ip2.workflowId();
                //先按业务类型排序
                int result = workflow1.getValue() - workflow2.getValue();
                //再按优先级排序
                if(result == 0) return priority1.compareTo(priority2);

                return result;
            }
            return 0;
        }
    }

}
