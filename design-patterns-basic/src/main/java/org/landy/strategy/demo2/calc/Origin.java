package org.landy.strategy.demo2.calc;

import org.landy.strategy.demo2.PriceRegion;

/**
 * @author landyl
 * @create 2:42 PM 05/12/2018
 */
@PriceRegion(max = 10000)
public class Origin implements CalPrice {
    @Override
    public Double calPrice(Double originPrice) {
        return originPrice;
    }
}
