package org.landy.builder.domain;

/**
 * @author landyl
 * @create 5:05 PM 05/12/2018
 */
public class Order {

    private String orderId;
    private String orderName;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return " 订单信息：" + orderId + "---" + orderName;
    }
}
