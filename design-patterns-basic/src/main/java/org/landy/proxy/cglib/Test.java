package org.landy.proxy.cglib;

/**
 * @author landyl
 * @create 9:49 AM 07/13/2018
 */
public class Test {

    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao)new ProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }

}
