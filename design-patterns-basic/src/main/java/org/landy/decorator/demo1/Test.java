package org.landy.decorator.demo1;

/**
 * @author landyl
 * @create 4:38 PM 07/16/2018
 */
public class Test {

    public static void main(String[] args) {
        ConcreteDecorator cd = new ConcreteDecorator(new ConcreteComponent());
        cd.method();
    }

}
