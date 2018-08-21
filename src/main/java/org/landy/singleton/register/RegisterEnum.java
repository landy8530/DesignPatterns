package org.landy.singleton.register;

/**
 * 利用枚举实现线程安全的单例
 * Created by Landy on 2018/8/21.
 */
public enum RegisterEnum {

    INSTANCE,BLACK,WHITE;
    public void getInstance(){}

}
