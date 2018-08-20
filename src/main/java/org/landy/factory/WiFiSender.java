package org.landy.factory;

import org.landy.factory.Sender;

/**
 * @author landyl
 * @create 4:32 PM 05/12/2018
 */
public class WiFiSender implements Sender {
    @Override
    public void sendData(byte[] data) {
        System.out.println("Send data by Wi-Fi");
    }
}
