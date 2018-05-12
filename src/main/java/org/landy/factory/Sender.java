package org.landy.factory;

/**
 * 把一段数据用Wi-Fi或者蓝牙发送出去。
 * @author landyl
 * @create 4:32 PM 05/12/2018
 */
public interface Sender {

    void sendData(byte[] data);

}
