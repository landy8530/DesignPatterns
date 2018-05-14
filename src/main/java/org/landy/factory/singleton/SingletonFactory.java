package org.landy.factory.singleton;

import java.lang.reflect.Constructor;

/**
 * Created by Landy on 2018/5/14.
 */
public class SingletonFactory {

    private static Singleton singleton;

    static {
        try {
            Class cl = Class.forName(Singleton.class.getName());
            //获得无参构造
            Constructor constructor = cl.getDeclaredConstructor();
            //设置无参构造是可访问的
            constructor.setAccessible(true);
            //实例化
            singleton = (Singleton) constructor.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Singleton getSingleton() {
        return singleton;
    }

}
