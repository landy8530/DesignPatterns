package org.landy.singleton.test;

import org.landy.singleton.lazy.LazyThree;

import java.lang.reflect.Constructor;

/**
 * Created by Landy on 2018/8/20.
 */
public class LazyThreeTest {

    public static void main(String[] args) {
        try{

            //很无聊的情况下，进行破坏
            Class<?> clazz = LazyThree.class;

            //通过反射拿到私有的构造方法
            Constructor c = clazz.getDeclaredConstructor(null);
            //强制访问，强吻，不愿意也要吻
            c.setAccessible(true);

            //暴力初始化
            Object o1 = c.newInstance();

            //调用了两次构造方法，相当于new了两次
            //犯了原则性问题，
            Object o2 = c.newInstance();

            System.out.println(o1 == o2);
//            Object o2 = c.newInstance();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
