package org.landy.prototype.simple;

import java.util.ArrayList;

/**
 * Created by Landy on 2018/8/21.
 */
public class CloneTest {

    public static void main(String[] args) {

        CloneTarget p = new CloneTarget();
        p.name = "Landy";
//        p.list = new ArrayList<CloneTarget>();
//        p.list.add(new CloneTarget());
        p.target = new CloneTarget();
        System.out.println(p.target);
//        System.out.println("p.list==="+p.list);
//        System.out.println(p.list.size());

        try {
            CloneTarget obj =  (CloneTarget) p.clone();
            System.out.println(obj.target);
//            System.out.println("obj.list==="+obj.list);
        } catch (Exception e) {
            e.printStackTrace();
        }




    }


}
