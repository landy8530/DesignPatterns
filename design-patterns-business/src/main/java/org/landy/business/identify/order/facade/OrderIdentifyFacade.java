package org.landy.business.identify.order.facade;

import org.landy.business.identify.component.enums.IdentificationStrategy;
import org.landy.business.identify.order.AbstractOrderIdentify;
import org.landy.business.identify.order.domain.OrderDetail;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author landyl
 * @create 4:27 PM 09/04/2018
 */
@Component
public class OrderIdentifyFacade {

    public void identifyOrders(int requestId) {
        //实际业务逻辑中，这里需要根据requestId去数据库中查询相应的数据
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (int i=0;i<10;i++) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setCustomerId(1l+i);
            orderDetail.setOrderId(2l);
            orderDetail.setOrderDetailId(3l);
            orderDetails.add(orderDetail);
        }
        //此处仅是演示用途
        if(requestId > 0) {
            AbstractOrderIdentify orderIdentify = AbstractOrderIdentify.accessOrderIdentifyInstance(IdentificationStrategy.FOREIGN_KEY_COMBINATION);
            orderIdentify.identifyOrders(requestId,orderDetails);
        } else {
            AbstractOrderIdentify orderIdentify = AbstractOrderIdentify.accessOrderIdentifyInstance(IdentificationStrategy.PRIMARY_KEY_COMBINATION);
            orderIdentify.identifyOrders(requestId,orderDetails);
        }

    }

}
