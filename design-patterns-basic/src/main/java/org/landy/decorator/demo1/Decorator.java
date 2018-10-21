package org.landy.decorator.demo1;

/**
 * 一般是一个抽象类,实现接口或者抽象方法
 * @author landyl
 * @create 2:55 PM 07/16/2018
 */
public abstract class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void method() {
        //委托给构件
        this.component.method();
    }

}
