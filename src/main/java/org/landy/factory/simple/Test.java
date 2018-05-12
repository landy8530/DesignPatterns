package org.landy.factory.simple;

import org.landy.factory.Sender;

/**
 * @author landyl
 * @create 4:34 PM 05/12/2018
 */
public class Test {

    private static String mode; //Wi-Fi|Bluetooth

    public static void onClick() {
        byte[] data = {0x00, 0x01};

        Sender sender = SimpleFactory.createSender(mode);
        sender.sendData(data);
    }

    public static void main(String[] args) {
        mode = "Wi-Fi";

        onClick();

    }

}
