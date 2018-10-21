package org.landy.business.identify.order.identification.primary;

import org.landy.business.enums.WorkflowEnum;
import org.landy.business.identify.component.annotation.KeyIdentificationStrategy;
import org.landy.business.identify.component.domain.IdentifyCriterion;
import org.landy.business.identify.component.enums.IdentificationResultType;
import org.landy.business.identify.component.primary.KeyIdentification;
import org.landy.business.identify.component.primary.KeyIdentificationChain;
import org.springframework.stereotype.Component;

/**
 * @author landyl
 * @create 10:52 AM 09/06/2018
 */
@KeyIdentificationStrategy(workflowId = WorkflowEnum.ORDER,beanName = OrderIdentification1.BEAN_NAME)
@Component
public class OrderIdentification1 implements KeyIdentification {

    public static final String BEAN_NAME = "orderIdentification1";

    @Override
    public IdentificationResultType doIdentify(IdentifyCriterion identifyCriterion, KeyIdentificationChain chain) {
        System.out.println("OrderIdentification1:此处逻辑需要按实际业务逻辑进行数据库相关操作");
        if(identifyCriterion.getOrderId() == 0) {
            return IdentificationResultType.SINGLE;
        }
        return chain.doIdentify(identifyCriterion,WorkflowEnum.ORDER);
    }
}
