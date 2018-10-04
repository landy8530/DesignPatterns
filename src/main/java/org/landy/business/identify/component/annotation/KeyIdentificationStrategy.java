package org.landy.business.identify.component.annotation;

import org.landy.business.enums.WorkflowEnum;

import java.lang.annotation.*;

/**
 * 组合主键查询策略（根据不同业务流程区分组合主键查询策略,并且每个业务流程都有自己的优先级策略）
 * @author landyl
 * @create 2:22 PM 09/29/2018
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface KeyIdentificationStrategy {

    /**
     * 主键策略优先级
     * 0 is the default value,It represents the highest priority (ie primary key priority)
     * @return
     */
    int priority() default 0;
    /**
     * 业务流程类型(如：订单信息，会员信息等业务流程)
     * @return
     */
    WorkflowEnum workflowId();
    /**
     * the spring bean name
     * @return
     */
    String beanName();

}
