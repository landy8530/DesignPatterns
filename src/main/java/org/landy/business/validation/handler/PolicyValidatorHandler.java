package org.landy.business.validation.handler;

import org.landy.business.enums.WorkflowEnum;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author landyl
 * @create 11:16 AM 05/09/2018
 */
@Component(PolicyValidatorHandler.BEAN_NAME)
public class PolicyValidatorHandler extends AbstractValidatorHandler {
    public static final String BEAN_NAME = "policyValidatorHandler";

    @Override
    protected WorkflowEnum getWorkflowId() {
        return WorkflowEnum.POLICY;
    }

    @Override
    protected Set<String> getBasePackages() {
        Set<String> packages = new HashSet<>();
        packages.add("org.landy.business.validation.detail.customer");
        packages.add("org.landy.business.validation.detail.component");
        return packages;
    }

    @Override
    protected Set<Class> excludeClasses() {
        Set<Class> classes = new HashSet<>();
        return classes;
    }

    @Override
    protected String accessBeanName() {
        return BEAN_NAME;
    }
}
