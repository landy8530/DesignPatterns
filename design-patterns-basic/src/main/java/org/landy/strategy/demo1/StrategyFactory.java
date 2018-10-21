package org.landy.strategy.demo1;

/**
 * @author landyl
 * @create 2:37 PM 05/12/2018
 */
public class StrategyFactory {

    public static void strategyMethod(String type) {
        Strategy strategy;

        if("a".equals(type)) {
            strategy = new ConcreteStrategyA();
        } else {
            strategy = new ConcreteStrategyB();
        }

        Context context = new Context(strategy);

        context.contextMethod();
    }

}
