package org.landy.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Landy on 2019/1/5.
 */
public class ObserverDemo {

    public static void main(String[] args) {
        //利用JDK中的Observer进行讲解
        MyObservable observable = new MyObservable();

        //注册观察者
        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("张三：邮件订阅：" + arg);
            }
        });
        observable.addObserver((o,arg)->{
            System.out.println("李四：邮件订阅：" + arg);
        });
        observable.addObserver((o,arg)->{
            System.out.println("王五：邮件订阅：" + arg);
        });
        //调整变化
        observable.setChanged();
        //通知
        observable.notifyObservers("Hello World");
    }

    private static class MyObservable extends Observable {
        //子类提升方法从protected 到 public
        //Observable设置为protected说明JDK不希望用户直接使用这个方法
        @Override
        public synchronized void setChanged() {
            super.setChanged();
        }
    }

}
