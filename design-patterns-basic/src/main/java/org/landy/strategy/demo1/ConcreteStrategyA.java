package org.landy.strategy.demo1;

/**
 * 策略实现A
 * @author landyl
 * @create 2:31 PM 05/12/2018
 */
public class ConcreteStrategyA implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("strategyMethod A....");
    }
}
