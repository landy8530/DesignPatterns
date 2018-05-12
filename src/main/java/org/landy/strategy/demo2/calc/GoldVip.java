package org.landy.strategy.demo2.calc;

import org.landy.strategy.demo2.PriceRegion;

/**
 * @author landyl
 * @create 2:44 PM 05/12/2018
 */
@PriceRegion(min=3000)
public class GoldVip implements CalPrice {
    @Override
    public Double calPrice(Double originPrice) {
        return originPrice * 0.7;
    }
}
