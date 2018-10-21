package org.landy.singleton;

/**
 * Created by Landy on 2018/5/12.
 * 测试单例类
 */
public class Test {

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        if (singleton1 == singleton2)
            System.out.println("same");
    }

}
