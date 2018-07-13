package org.landy.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author landyl
 * @create 9:44 AM 07/13/2018
 */
public class ProxyFactory {

    //维护一个目标对象
    private Object target;
    public ProxyFactory(Object target){
        this.target=target;
    }
    //给目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DynamicProxyHandler(target)
        );
    }

    /**
     * 动态处理器
     */
    private class DynamicProxyHandler implements InvocationHandler {
        //维护一个目标对象
        private Object target;
        public DynamicProxyHandler(Object target){
            this.target=target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("JDK代理：开始事务...");
            //执行目标对象方法
            Object returnValue = method.invoke(target, args);
            System.out.println("JDK代理：提交事务...");
            return returnValue;
        }

    }

}

