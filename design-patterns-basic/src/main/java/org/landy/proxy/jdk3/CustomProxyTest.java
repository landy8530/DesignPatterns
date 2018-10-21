package org.landy.proxy.jdk3;

public class CustomProxyTest {

    public static void main(String[] args) {

        try {
            Person obj = (Person)new CustomMeipo().getInstance(new XieMu());
            System.out.println(obj.getClass());
            obj.findLove();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
