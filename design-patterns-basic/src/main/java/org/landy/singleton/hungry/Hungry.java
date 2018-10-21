package org.landy.singleton.hungry;

/**
 * Created by Landy on 2018/8/20.
 */
public class Hungry {

    private Hungry() {}

    //先静态后动态
    //先属性后方法
    //先上后下
    private static final Hungry instance = new Hungry();

    public static Hungry getInstance() {
//        System.out.println(System.currentTimeMillis()+"===" + instance);
        return instance;
    }

}
