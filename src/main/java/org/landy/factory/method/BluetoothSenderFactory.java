package org.landy.factory.method;

import org.landy.factory.Sender;
import org.landy.factory.BluetoothSender;

/**
 * @author landyl
 * @create 4:37 PM 05/12/2018
 */
public class BluetoothSenderFactory implements SenderFactory {
    @Override
    public Sender createSender() {
        return new BluetoothSender();
    }
}
