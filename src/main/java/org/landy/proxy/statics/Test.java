package org.landy.proxy.statics;

import org.landy.proxy.common.UserDao;

/**
 * @author landyl
 * @create 9:43 AM 07/13/2018
 */
public class Test {

    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDao();

        //代理对象,把目标对象传给代理对象,建立代理关系
        UserDaoProxy proxy = new UserDaoProxy(target);

        proxy.save();//执行的是代理的方法
    }

}
