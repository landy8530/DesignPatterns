package org.landy.strategy.demo2.calc;

import org.landy.strategy.demo2.PriceRegion;

/**
 * @author landyl
 * @create 2:43 PM 05/12/2018
 */
@PriceRegion(max=20000)
public class Vip implements CalPrice {
    @Override
    public Double calPrice(Double originPrice) {
        return originPrice * 0.9;
    }
}
