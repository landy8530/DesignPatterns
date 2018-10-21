package org.landy.factory.method;

import org.landy.factory.Sender;

/**
 * 在简单工厂模式的基础上，让我们对工厂类也升级一下，首先定义一个工厂类接口：
 * @author landyl
 * @create 4:36 PM 05/12/2018
 */
public interface SenderFactory {

    Sender createSender();

}
