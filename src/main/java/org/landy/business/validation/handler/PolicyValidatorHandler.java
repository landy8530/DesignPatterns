package org.landy.business.validation.handler;

import org.landy.business.enums.WorkflowEnum;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author landyl
 * @create 11:16 AM 05/09/2018
 */
@Component
public class PolicyValidatorHandler extends AbstractValidatorHandler {

    @Override
    protected WorkflowEnum getWorkflowId() {
        return WorkflowEnum.POLICY;
    }

    @Override
    protected Set<String> getBasePackages() {
        Set<String> packages = new HashSet<>();
        packages.add("com.ehi.csync.request.validation.detail.policy");
        packages.add("com.ehi.csync.request.validation.detail.common");
        return packages;
    }

    @Override
    protected Set<Class> excludeClasses() {
        Set<Class> classes = new HashSet<>();
        return classes;
    }


}
