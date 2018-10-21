package org.landy.strategy.pay.payport;


import org.landy.strategy.pay.PayState;

/**
 * 具体支付策略
 * Created by Landy on 2018/9/11.
 */
public class WechatPay implements Payment {

    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("欢迎使用微信支付");
        System.out.println("直接从微信红包扣款");
        return new PayState(200,"支付成功",amount);
    }
}
