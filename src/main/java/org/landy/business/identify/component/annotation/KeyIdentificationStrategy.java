package org.landy.business.identify.component.annotation;

import org.landy.business.enums.WorkflowEnum;

import java.lang.annotation.*;

/**
 * 组合主键查询策略（根据不同业务流程区分组合主键查询策略）
 * @author landyl
 * @create 2:22 PM 09/29/2018
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface KeyIdentificationStrategy {

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
