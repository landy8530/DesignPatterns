package org.landy.chain.responsibility.demo1;

/**
 * @author landyl
 * @create 2:03 PM 05/12/2018
 */
public class ConcreteHandlerA extends AbstractHandler {
    @Override
    public void handleRequest(String condition) {
        if (condition.equals("A")) {
            System.out.println("ConcreteHandlerA处理");
        } else {
            System.out.println("ConcreteHandlerA不处理，由其他的Handler处理");
            super.getNextHandler().handleRequest(condition);
        }
    }
}
