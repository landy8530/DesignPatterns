package org.landy.business.validation.handler;

import org.landy.business.enums.WorkflowEnum;
import org.landy.business.validation.util.ValidatorUtil;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author landyl
 * @create 11:16 AM 05/09/2018
 */
@Component(CustomerValidatorHandler.BEAN_NAME)
public class CustomerValidatorHandler extends AbstractValidatorHandler {
    public static final String BEAN_NAME = "customerValidatorHandler";

    @Override
    protected WorkflowEnum getWorkflowId() {
        return WorkflowEnum.POLICY;
    }

    @Override
    protected Set<String> getBasePackages() {
        Set<String> packages = new HashSet<>();
        packages.add("org.landy.business.validation.detail.customer");
        packages.add("org.landy.business.validation.detail.common");
        return packages;
    }

    @Override
    protected Set<Class> excludeClasses() {
        Set<Class> classes = new HashSet<>();
        classes.addAll(excludeConstrainedColumnValidatorClasses());
        return classes;
    }

    /**
     * 需要排除的约束字段校验器
     * @see org.landy.business.validation.detail.customer.ConstrainedColumnValidator
     * @return
     */
    private Set<Class> excludeConstrainedColumnValidatorClasses() {
        return ValidatorUtil.constrainedColumnValidatorClasses();
    }

    @Override
    protected String accessBeanName() {
        return BEAN_NAME;
    }
}
