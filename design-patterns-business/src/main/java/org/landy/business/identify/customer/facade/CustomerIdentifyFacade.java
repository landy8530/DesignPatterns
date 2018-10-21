package org.landy.business.identify.customer.facade;

import org.landy.business.identify.component.enums.IdentificationStrategy;
import org.landy.business.identify.customer.AbstractCustomerIdentify;
import org.landy.business.identify.customer.domain.CustomerDetail;
import org.landy.business.identify.order.domain.OrderDetail;
import org.landy.utils.DateUtil;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author landyl
 * @create 4:27 PM 09/04/2018
 */
@Component
public class CustomerIdentifyFacade {

    public void identifyCustomers(int requestId) {
        List<CustomerDetail> customerDetails = new ArrayList<>();
        for (int i=0;i<10;i++) {
            CustomerDetail customerDetail = new CustomerDetail();
            customerDetail.setCustomerId(i);
            customerDetail.setBirthDate(DateUtil.getSysDate());
            customerDetail.setFirstName("Landy"+i);
            customerDetails.add(customerDetail);
        }
        //此处仅是演示用途
        if(requestId > 0) {
            AbstractCustomerIdentify customerIdentify = AbstractCustomerIdentify.accessCustomerIdentifyInstance(IdentificationStrategy.FOREIGN_KEY_COMBINATION);
            customerIdentify.identifyCustomers(requestId,customerDetails);
        } else {
            AbstractCustomerIdentify customerIdentify = AbstractCustomerIdentify.accessCustomerIdentifyInstance(IdentificationStrategy.PRIMARY_KEY_COMBINATION);
            customerIdentify.identifyCustomers(requestId,customerDetails);
        }

    }

}
