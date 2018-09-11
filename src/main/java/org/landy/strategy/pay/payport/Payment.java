package org.landy.strategy.pay.payport;


import org.landy.strategy.pay.PayState;

/**
 * 支付渠道(相当于支付策略)
 * Created by Landy on 2018/9/11.
 */
public interface Payment {

    PayState pay(String uid, double amount);

}
