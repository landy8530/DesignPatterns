package org.landy.chain.responsibility.demo1;

/**
 * @author landyl
 * @create 2:05 PM 05/12/2018
 */
public class ConcreteHandlerZ extends AbstractHandler {
    @Override
    public void handleRequest(String condition) {
        //一般是最后一个处理者
        System.out.println("ConcreteHandlerZ处理");
    }
}
