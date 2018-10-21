package org.landy.chain.responsibility.demo1;

/**
 * @author landyl
 * @create 2:04 PM 05/12/2018
 */
public class ConcreteHandlerB extends AbstractHandler {
    @Override
    public void handleRequest(String condition) {
        if (condition.equals("B")) {
            System.out.println("ConcreteHandlerB处理");
        } else {
            System.out.println("ConcreteHandlerB不处理，由其他的Handler处理");
            super.getNextHandler().handleRequest(condition);
        }
    }
}
