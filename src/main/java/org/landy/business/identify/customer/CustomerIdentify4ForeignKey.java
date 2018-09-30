package org.landy.business.identify.customer;

import org.landy.business.enums.WorkflowEnum;
import org.landy.business.identify.component.enums.IdentificationStrategy;
import org.landy.business.identify.customer.domain.CustomerDetail;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 客户信息外键组合查询
 * @author landyl
 * @create 5:09 PM 09/04/2018
 */
@Component(CustomerIdentify4ForeignKey.BEAN_NAME)
public class CustomerIdentify4ForeignKey extends AbstractCustomerIdentify {
    public static final String BEAN_NAME = "customerIdentify4ForeignKey";

    @Override
    public void identifyCustomers(int requestId, List<CustomerDetail> customerDetails) {
        LOGGER.info("customerIdentify4ForeignKey.............");
    }

    @Override
    protected IdentificationStrategy accessIdentificationStrategy() {
        return IdentificationStrategy.FOREIGN_KEY_COMBINATION;
    }

    @Override
    protected WorkflowEnum accessWorkflow() {
        return WorkflowEnum.CUSTOMER;
    }

    @Override
    protected String accessBeanName() {
        return BEAN_NAME;
    }
}
