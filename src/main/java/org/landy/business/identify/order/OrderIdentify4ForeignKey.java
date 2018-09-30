package org.landy.business.identify.order;

import org.landy.business.enums.WorkflowEnum;
import org.landy.business.identify.component.enums.IdentificationStrategy;
import org.landy.business.identify.order.domain.OrderDetail;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author landyl
 * @create 9:00 AM 09/30/2018
 */
@Component(OrderIdentify4ForeignKey.BEAN_NAME)
public class OrderIdentify4ForeignKey extends AbstractOrderIdentify {
    public static final String BEAN_NAME = "orderIdentify4ForeignKey";

    @Override
    public void identifyOrders(int requestId, List<OrderDetail> orderDetails) {
        System.out.println("OrderIdentify4ForeignKey");
    }

    @Override
    protected IdentificationStrategy accessIdentificationStrategy() {
        return IdentificationStrategy.FOREIGN_KEY_COMBINATION;
    }

    @Override
    protected WorkflowEnum accessWorkflow() {
        return WorkflowEnum.ORDER;
    }

    @Override
    protected String accessBeanName() {
        return BEAN_NAME;
    }
}
