package org.landy.factory.method;

import org.landy.factory.Sender;
import org.landy.factory.WiFiSender;

/**
 * 为每一个发送器的实现类各创建一个具体的工厂方法去实现这个接口
 * @author landyl
 * @create 4:36 PM 05/12/2018
 */
public class WiFiSenderFactory implements SenderFactory {
    @Override
    public Sender createSender() {
        return new WiFiSender();
    }
}
