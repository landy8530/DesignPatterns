package org.landy.chain.responsibility.demo1;

/**
 * @author landyl
 * @create 2:05 PM 05/12/2018
 */
public class ChainClient {
    public static void main(String[] args) {
        AbstractHandler handlerA = new ConcreteHandlerA();
        AbstractHandler handlerB = new ConcreteHandlerB();
        AbstractHandler handlerZ = new ConcreteHandlerZ();
        // 如A处理不掉转交给B
        handlerA.setNextHandler(handlerB);
        handlerB.setNextHandler(handlerZ);
        handlerA.handleRequest("Z");
    }
}
