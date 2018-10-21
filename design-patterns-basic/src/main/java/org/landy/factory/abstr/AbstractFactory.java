package org.landy.factory.abstr;

import org.landy.factory.Sender;

/**
 * 抽象工厂优势：
 * 1.易于管理
 * 2.易于扩展
 * Created by Landy on 2018/8/20.
 */
public abstract class AbstractFactory {

    public abstract Sender createBluetoothSender();

    public abstract Sender createWifiSender();

}
