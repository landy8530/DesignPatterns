package org.landy.singleton.lazy;

/**
 * 测试结果，存在线程安全问题
 * 1534776511667===org.landy.singleton.lazy.LazyOne@24ca5fab
   1534776511667===org.landy.singleton.lazy.LazyOne@1698a591
   1534776511667===org.landy.singleton.lazy.LazyOne@24ca5fab
 * Created by Landy on 2018/8/20.
 */
public class LazyTwo {

    private LazyTwo() {}

    private static LazyTwo instance = null;
    //存在性能问题
    public static synchronized LazyTwo getInstance() {
        if(instance == null) {
            instance = new LazyTwo();
        }

        return instance;
    }

}
