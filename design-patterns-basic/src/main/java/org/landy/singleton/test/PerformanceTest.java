package org.landy.singleton.test;

import org.landy.singleton.lazy.LazyOne;
import org.landy.singleton.lazy.LazyThree;
import org.landy.singleton.lazy.LazyTwo;

/**
 * 经过测试，是线程安全
 * Created by Landy on 2018/8/20.
 */
public class PerformanceTest {

    public static void main(String[] args) {
        int count = 200000000;
        long start = System.currentTimeMillis();
        for(int i=0;i<count;i++) {
//            Object obj = LazyOne.getInstance(); //9
//            Object obj = LazyTwo.getInstance(); //synchronized 存在性能问题
            Object obj = LazyThree.getInstance(); //8
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));//one = 9 two = 9182 three=8
    }

}
