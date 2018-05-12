package org.landy.strategy.demo2.calc;

/**
 * @author landyl
 * @create 2:42 PM 05/12/2018
 */
public interface CalPrice {

    //根据原价返回一个最终的价格
    Double calPrice(Double originPrice);

}
