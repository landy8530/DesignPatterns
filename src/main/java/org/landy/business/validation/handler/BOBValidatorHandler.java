package org.landy.business.validation.handler;

import org.landy.business.enums.WorkflowEnum;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author landyl
 * @create 11:16 AM 05/09/2018
 */
@Component(BOBValidatorHandler.BEAN_NAME)
public class BOBValidatorHandler extends AbstractValidatorHandler {
    public static final String BEAN_NAME = "bOBValidatorHandler";

    @Override
    protected WorkflowEnum getWorkflowId() {
        return WorkflowEnum.BOB;
    }

    @Override
    protected Set<String> getBasePackages() {
        Set<String> packages = new HashSet<>();
        packages.add("org.landy.business.validation.detail.bob");
        packages.add("org.landy.business.validation.detail.common");
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
