package org.landy.business.validation.handler;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.landy.business.domain.detail.RequestDetail;
import org.landy.business.domain.file.RequestFile;
import org.landy.business.enums.WorkflowEnum;
import org.landy.business.validation.Validator;
import org.landy.business.validation.detail.FileDetailValidatorChain;
import org.landy.exception.BusinessValidationException;
import org.landy.utils.PackageUtil;
import org.landy.web.utils.ApplicationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.*;

/**
 * @author landyl
 * @create 9:34 AM 05/10/2018
 */
public abstract class AbstractValidatorHandler implements ApplicationListener<ContextRefreshedEvent> {
    protected static Logger LOGGER = LoggerFactory.getLogger(AbstractValidatorHandler.class);

    private ClassLoader classLoader = getClass().getClassLoader();

    private static Map<WorkflowEnum,String> validatorHandlerMap = new HashMap<>();

    @Autowired
    protected FileDetailValidatorChain fileDetailValidatorChain;

    public AbstractValidatorHandler() {
        validatorHandlerMap.put(getWorkflowId(),accessBeanName());
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            LOGGER.info("Start to add the validator into current handler,base packages contains:{}",this.getBasePackages());
            this.addValidators();
        }
    }

    public String validate(RequestDetail requestDetail, RequestFile requestFile) {
        //must set the current workflowId
        fileDetailValidatorChain.setWorkflowId(getWorkflowId());
        fileDetailValidatorChain.doClearValidatorIndex(getWorkflowId());
        return fileDetailValidatorChain.doValidate(requestDetail, requestFile);
    }

    /**
     * Generate a AbstractValidatorHandler Object
     * @param updateWorkflowId
     * @return
     */
    public static final AbstractValidatorHandler accessValidatorHandler(WorkflowEnum updateWorkflowId) {
        String beanName = validatorHandlerMap.get(updateWorkflowId);
        if(StringUtils.isEmpty(beanName)) {
            LOGGER.error("can not find {}'s component",beanName);
            throw new BusinessValidationException("can not find "+beanName + "'s component,current UPDATE_WORKFLOW_ID is :" + updateWorkflowId);
        }
        return ApplicationUtil.getApplicationContext().getBean(beanName,AbstractValidatorHandler.class);
    }

    protected void addValidator(String beanName,Class<? extends Validator> validator) {
        Validator validatorInstance = ApplicationUtil.getApplicationContext().getBean(beanName,validator);
        fileDetailValidatorChain.addValidator(validatorInstance,getWorkflowId());
    }

    protected abstract WorkflowEnum getWorkflowId();
    /**
     * the package need to be added the validators
     * @return
     */
    protected abstract Set<String> getBasePackages();

    /**
     * the classes need to be excluded
     * @return
     */
    protected abstract Set<Class> excludeClasses();

    /**
     * the spring bean name
     * @return
     */
    protected abstract String accessBeanName();

    private void addValidators() {
        List<Class<? extends Validator>> validators = getValidators();

        validators.forEach((validator) -> {
            String simpleName = validator.getSimpleName();
            String beanName = simpleName.substring(0, 1).toLowerCase() + simpleName.substring(1);

            LOGGER.info("Added validator:{},spring bean name is:{}",simpleName,beanName);

            Validator validatorInstance = ApplicationUtil.getApplicationContext().getBean(beanName,validator);

            fileDetailValidatorChain.addValidator(validatorInstance,getWorkflowId());

        });
    }

    private List<Class<? extends Validator>> getValidators() {
        Set<String> packageNames = this.getBasePackages();
        List<Class<? extends Validator>> validators = new ArrayList<>();
        if(packageNames != null) {
            packageNames.forEach((packageName) -> validators.addAll(getValidators(packageName)));
        }
        return validators;
    }

    private List<Class<? extends Validator>> getValidators(String packageName) {
        Set<Class<?>> classes = PackageUtil.getClzFromPkg(packageName);

        Class<Validator> validatorClazz;
        try {
            validatorClazz = (Class<Validator>) classLoader.loadClass(Validator.class.getName());//
        } catch (ClassNotFoundException e1) {
            throw new RuntimeException("The Validator interface has not found");
        }

        if(CollectionUtils.isNotEmpty(classes)) {
            List<Class<? extends Validator>> validators = new ArrayList<>(classes.size());
            classes.forEach(clazz->{
                if (Validator.class.isAssignableFrom(clazz) && clazz != validatorClazz) {
                    Set<Class> excludeClasses = this.excludeClasses();
                    if(excludeClasses!= null && !excludeClasses.contains(clazz)) {
                        validators.add((Class<? extends Validator>) clazz);
                    } else {
                        if(excludeClasses == null || excludeClasses.isEmpty()) {
                            validators.add((Class<? extends Validator>) clazz);
                        }
                    }
                }
            });
            return validators;
        }

        return new ArrayList<>(0);
    }

}
