package org.landy.factory.method;

import org.landy.factory.Sender;

/**
 * @author landyl
 * @create 4:38 PM 05/12/2018
 */
public class Test {

    private static String mode; //Wi-Fi|Bluetooth

    public static void onClick() {
        byte[] data = {0x00, 0x01};

        SenderFactory factory;
        if ("Wi-Fi".equals(mode)) {
            factory = new WiFiSenderFactory();
        } else {
            factory = new BluetoothSenderFactory();
        }
        Sender sender = factory.createSender();
        sender.sendData(data);
    }

    public static void main(String[] args) {
        mode = "Wi-Fi";

        onClick();
    }

}
