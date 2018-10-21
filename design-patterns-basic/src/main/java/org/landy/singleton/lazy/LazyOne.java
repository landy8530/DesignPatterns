package org.landy.singleton.lazy;

/**
 * 在外部需要使用的时候才进行实例化
 * 测试结果，存在线程安全问题
 * 1534776511667===org.landy.singleton.lazy.LazyOne@24ca5fab
   1534776511667===org.landy.singleton.lazy.LazyOne@1698a591
   1534776511667===org.landy.singleton.lazy.LazyOne@24ca5fab
 * Created by Landy on 2018/8/20.
 */
public class LazyOne {

    private LazyOne() {}
    //静态块，公共内存区域
    private static LazyOne instance = null;

    public static LazyOne getInstance() {
        //调用方法之前，先判断
        //如果没有初始化，将其进行初始化,并且赋值
        //将该实例缓存好
        if(instance == null) {
            //两个线程都会进入这个if里面
            instance = new LazyOne();
        }
        //如果已经初始化，直接返回之前已经保存好的结果
        return instance;
    }

}
