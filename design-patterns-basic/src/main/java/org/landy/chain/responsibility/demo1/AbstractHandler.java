package org.landy.chain.responsibility.demo1;

/**
 * 定义AbstractHandler（抽象处理者），使子类形成一条链
 * @author landyl
 * @create 2:02 PM 05/12/2018
 */
public abstract class AbstractHandler {

    private AbstractHandler nextHandler;

    public abstract void handleRequest(String condition);

    public AbstractHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

}
