package org.landy.proxy.jdk3;

import java.lang.reflect.Method;

public interface MyInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
