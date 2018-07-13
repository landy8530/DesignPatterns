package org.landy.proxy.jdk;

import org.landy.proxy.common.IUserDao;
import org.landy.proxy.common.UserDao;

/**
 * 动态代理：代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理
 * @author landyl
 * @create 9:45 AM 07/13/2018
 */
public class Test {

    public static void main(String[] args) {

        // 目标对象
        IUserDao target = new UserDao();
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        // 执行方法   【代理对象】
        proxy.save();
    }

}
