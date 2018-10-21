package org.landy.prototype.simple;

import java.util.ArrayList;

/**
 * Created by Landy on 2018/8/21.
 */
public class Prototype implements Cloneable {

    public String name;

    CloneTarget target = null;

    public ArrayList<CloneTarget> list;
//
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }


}
