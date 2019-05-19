package org.landy.adapter.objectadapter;

import org.landy.adapter.domain.PS2;
import org.landy.adapter.domain.USB;

/**
 * @author: landy
 * @date: 2019/5/19 11:52
 * @description:
 */
public class PS2ToUsberAdapter implements PS2 {

    private USB usb;

    public PS2ToUsberAdapter(USB usb) {
        this.usb = usb;
    }

    @Override
    public boolean isPs2() {
        System.out.println("PS2接口转化为了USB接口");
        return usb.isUsb();
    }
}
