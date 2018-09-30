package org.landy.business.identify.order;

import org.apache.commons.lang3.StringUtils;
import org.landy.business.enums.WorkflowEnum;
import org.landy.business.identify.component.AbstractIdentify;
import org.landy.business.identify.component.enums.IdentificationStrategy;
import org.landy.business.identify.order.domain.OrderDetail;
import org.landy.exception.BusinessValidationException;
import org.landy.web.utils.ApplicationUtil;

import java.util.List;

/**
 * Order Identify process
 * @author landyl
 * @create 2:39 PM 09/25/2018
 */
public abstract class AbstractOrderIdentify extends AbstractIdentify {

    public abstract void identifyOrders(int requestId, List<OrderDetail> orderDetails);

    /**
     * Generate a AbstractCustomerIdentify Object
     * @param identificationStrategy
     * @return
     */
    public static final AbstractOrderIdentify accessOrderIdentifyInstance(IdentificationStrategy identificationStrategy) {
        String key = keyOfMap(WorkflowEnum.ORDER,identificationStrategy);
        String beanName = identifyHandlerMap.get(key);
        if(StringUtils.isEmpty(beanName)) {
            LOGGER.error("can not find {}'s component",beanName);
            throw new BusinessValidationException("can not find "+beanName + "'s component,current identificationStrategy is :" + identificationStrategy);
        }
        return ApplicationUtil.getApplicationContext().getBean(beanName,AbstractOrderIdentify.class);
    }

}
