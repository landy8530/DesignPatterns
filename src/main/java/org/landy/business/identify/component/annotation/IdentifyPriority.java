package org.landy.business.identify.component.annotation;

import org.landy.business.enums.WorkflowEnum;

import java.lang.annotation.*;

/**
 * define a priority of the identification,priority is decremented from 0
 * @author landyl
 * @create 5:29 PM 09/05/2018
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface IdentifyPriority {
    /**
     * indicates the priority value.
     * 0 is the default value,It represents the highest priority (ie primary key priority)
     * @return
     */
    int priority() default 0;

    /**
     * 业务流程类型(如：订单信息，会员信息等业务流程)
     * @return
     */
    WorkflowEnum workflowId();
}
