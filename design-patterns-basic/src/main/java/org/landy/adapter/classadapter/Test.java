package org.landy.adapter.classadapter;

import org.landy.adapter.domain.PS2;

/**
 * @author: landy
 * @date: 2019/5/19 11:39
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        PS2 p = new PS2ToUsberAdapter();
        p.isPs2();
    }

}
