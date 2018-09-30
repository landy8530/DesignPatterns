package org.landy.business.identify.component.util;

import org.apache.commons.beanutils.BeanUtils;
import org.landy.business.identify.order.domain.OrderDetail;
import org.landy.business.identify.component.domain.IdentifyCriterion;
import org.landy.business.identify.customer.domain.CustomerDetail;

import java.lang.reflect.InvocationTargetException;

/**
 * 工具类
 * @author landyl
 * @create 2:27 PM 09/07/2018
 */
public class IdentifyCriterionUtil {

    public static IdentifyCriterion convert2IdentifyCriterionFromCustomer(CustomerDetail customerDetail) {
        IdentifyCriterion identifyCriterion = new IdentifyCriterion();

        try {
            BeanUtils.copyProperties(identifyCriterion,customerDetail);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        identifyCriterion.setSourceId(customerDetail.getCustomerDetailId());//set the value to source id
        return identifyCriterion;

    }

    public static IdentifyCriterion convert2IdentifyCriterionFromOrder(OrderDetail appDetail) {
        IdentifyCriterion identifyCriterion = new IdentifyCriterion();

        try {
            BeanUtils.copyProperties(identifyCriterion,appDetail);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        identifyCriterion.setSourceId(appDetail.getOrderDetailId().intValue());//set the value to source id
        return identifyCriterion;

    }

}
