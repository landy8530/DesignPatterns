package org.landy.business.identify.order;

import org.apache.commons.collections.CollectionUtils;
import org.landy.business.enums.WorkflowEnum;
import org.landy.business.identify.component.domain.IdentifyCriterion;
import org.landy.business.identify.component.enums.IdentificationResultType;
import org.landy.business.identify.component.enums.IdentificationStrategy;
import org.landy.business.identify.component.factory.KeyIdentificationFactory;
import org.landy.business.identify.component.util.IdentifyCriterionUtil;
import org.landy.business.identify.order.domain.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author landyl
 * @create 8:59 AM 09/30/2018
 */
@Component(OrderIdentify4PrimaryKey.BEAN_NAME)
public class OrderIdentify4PrimaryKey extends AbstractOrderIdentify {
    public static final String BEAN_NAME = "orderIdentify4PrimaryKey";

    @Autowired
    private KeyIdentificationFactory keyIdentificationFactory;

    @Override
    public void identifyOrders(int requestId, List<OrderDetail> orderDetails) {
        LOGGER.info("orderIdentify4PrimaryKey");
        if(CollectionUtils.isNotEmpty(orderDetails)) {
            orderDetails.parallelStream().forEach(orderDetail -> {
                //initialize
                IdentifyCriterion identifyCriterion = IdentifyCriterionUtil.convert2IdentifyCriterionFromOrder(orderDetail);
                identifyCriterion.setRequestId(requestId);
                //identify operation
                IdentificationResultType identificationResult = keyIdentificationFactory.identify(identifyCriterion,WorkflowEnum.ORDER);

                LOGGER.info("identificationResult:,{}",identificationResult.name());
            });
        }
    }

    @Override
    protected IdentificationStrategy accessIdentificationStrategy() {
        return IdentificationStrategy.PRIMARY_KEY_COMBINATION;
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
