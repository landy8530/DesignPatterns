package org.landy.flyweight;

/**
 * Created by Landy on 2019/1/5.
 */
public class StringInterningDemo {

    public static void main(String[] args) {
        String s = new String("Hello World"); //放在Heap中
        String newValue = s.intern();//放在常量池中

        System.out.println(newValue);
    }

}
