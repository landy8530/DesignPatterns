package org.landy.business.identify.customer;

import org.apache.commons.lang3.StringUtils;
import org.landy.business.enums.WorkflowEnum;
import org.landy.business.identify.component.AbstractIdentify;
import org.landy.business.identify.component.enums.IdentificationStrategy;
import org.landy.business.identify.customer.domain.CustomerDetail;
import org.landy.exception.BusinessValidationException;
import org.landy.web.utils.ApplicationUtil;

import java.util.List;

/**
 * The common standard customer identify process
 * @author landyl
 * @create 4:58 PM 09/04/2018
 */
public abstract class AbstractCustomerIdentify extends AbstractIdentify {

    public abstract void identifyCustomers(int requestId, List<CustomerDetail> customerDetails);

    /**
     * Generate a AbstractCustomerIdentify Object
     * @param identificationStrategy
     * @return
     */
    public static final AbstractCustomerIdentify accessCustomerIdentifyInstance(IdentificationStrategy identificationStrategy) {
        String key = keyOfMap(WorkflowEnum.CUSTOMER,identificationStrategy);
        String beanName = identifyHandlerMap.get(key);
        if(StringUtils.isEmpty(beanName)) {
            LOGGER.error("can not find {}'s component",beanName);
            throw new BusinessValidationException("can not find "+beanName + "'s component,current identificationStrategy is :" + identificationStrategy);
        }
        return ApplicationUtil.getApplicationContext().getBean(beanName,AbstractCustomerIdentify.class);
    }

}
