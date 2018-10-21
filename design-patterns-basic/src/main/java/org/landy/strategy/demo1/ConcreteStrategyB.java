package org.landy.strategy.demo1;

/**
 * 策略实现B
 * @author landyl
 * @create 2:32 PM 05/12/2018
 */
public class ConcreteStrategyB implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("strategyMethod B....");
    }
}
