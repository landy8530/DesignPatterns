package org.landy.adapter.objectadapter;

import org.landy.adapter.domain.PS2;
import org.landy.adapter.domain.Usber;

/**
 * @author: landy
 * @date: 2019/5/19 11:55
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        PS2 p = new PS2ToUsberAdapter(new Usber());
        p.isPs2();
    }

}
