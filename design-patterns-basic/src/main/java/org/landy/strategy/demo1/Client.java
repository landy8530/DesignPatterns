package org.landy.strategy.demo1;

/**
 * @author landyl
 * @create 2:34 PM 05/12/2018
 */
public class Client {

    public static void main(String[] args) {
//        ConcreteStrategyA a = new ConcreteStrategyA();
//        ConcreteStrategyB b = new ConcreteStrategyB();
//
//        Context context = new Context(a);
//
//        context.contextMethod();

        //可使用工厂模式包装一下
        StrategyFactory.strategyMethod("a");

    }

}
