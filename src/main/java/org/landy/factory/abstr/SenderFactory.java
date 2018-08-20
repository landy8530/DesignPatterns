package org.landy.factory.abstr;

import org.landy.factory.BluetoothSender;
import org.landy.factory.Sender;
import org.landy.factory.WiFiSender;

/**
 * Created by Landy on 2018/8/20.
 */
public class SenderFactory extends AbstractFactory {
    @Override
    public Sender createBluetoothSender() {
        return new BluetoothSender();
    }

    @Override
    public Sender createWifiSender() {
        return new WiFiSender();
    }
}
