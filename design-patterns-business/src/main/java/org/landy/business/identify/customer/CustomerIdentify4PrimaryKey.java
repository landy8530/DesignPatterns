package org.landy.business.identify.customer;

import org.apache.commons.collections.CollectionUtils;
import org.landy.business.enums.WorkflowEnum;
import org.landy.business.identify.component.domain.IdentifyCriterion;
import org.landy.business.identify.component.enums.IdentificationResultType;
import org.landy.business.identify.component.enums.IdentificationStrategy;
import org.landy.business.identify.component.factory.KeyIdentificationFactory;
import org.landy.business.identify.component.util.IdentifyCriterionUtil;
import org.landy.business.identify.customer.domain.CustomerDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author landyl
 * @create 5:09 PM 09/04/2018
 */
@Component(CustomerIdentify4PrimaryKey.BEAN_NAME)
public class CustomerIdentify4PrimaryKey extends AbstractCustomerIdentify {
    public static final String BEAN_NAME = "policyIdentify4PrimaryKey";

    @Autowired
    private KeyIdentificationFactory keyIdentificationFactory;

    @Override
    public void identifyCustomers(int requestId, List<CustomerDetail> customerDetails) {
        LOGGER.info("customerIdentify4PrimaryKey");
        if(CollectionUtils.isNotEmpty(customerDetails)) {
            customerDetails.parallelStream().forEach(customerDetail -> {
                //initialize
                IdentifyCriterion identifyCriterion = IdentifyCriterionUtil.convert2IdentifyCriterionFromCustomer(customerDetail);
                identifyCriterion.setRequestId(requestId);
                //identify operation
                IdentificationResultType identificationResult = keyIdentificationFactory.identify(identifyCriterion,WorkflowEnum.CUSTOMER);

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
        return WorkflowEnum.CUSTOMER;
    }

    @Override
    protected String accessBeanName() {
        return BEAN_NAME;
    }
}
