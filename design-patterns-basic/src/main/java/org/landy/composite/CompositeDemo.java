package org.landy.composite;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Landy on 2019/1/5.
 */
public class CompositeDemo {

    public static void main(String[] args) {

    }

    private interface A {
        void save();
    }

    private class AImpl implements A {
        @Override
        public void save() {
            System.out.println("save...");
        }
    }

    private class CompositeA
//            implements A
    { //此处implements A 可有可不有
       private Collection<A> list = new ArrayList<>();

//        @Override
        public void save() {
            list.forEach(a -> a.save());
        }
    }
}
