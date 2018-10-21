package org.landy.singleton.test;

import org.landy.singleton.hungry.Hungry;
import org.landy.singleton.lazy.LazyOne;
import org.landy.singleton.lazy.LazyThree;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * 经过测试，是线程安全
 * Created by Landy on 2018/8/20.
 */
public class ThreadSafeTest {

    public static void main(String[] args) {
        int count = 200;
        //发令枪，我就能想到运动员
        CountDownLatch latch = new CountDownLatch(count);

        //final Set<Hungry> syncSet = Collections.synchronizedSet(new HashSet<Hungry>()) ;
        long start = System.currentTimeMillis();
        for(int i=0;i<count;i++) {
            new Thread() {
                @Override
                public void run() {
                    //Hungry obj = Hungry.getInstance();
                    try {
                        // 阻塞
                        // count = 0 就会释放所有的共享锁
                        // 万箭齐发
                        latch.await();
                    }catch(Exception e){
                        e.printStackTrace();
                    }

//                    LazyOne obj = LazyOne.getInstance();//必然会调用，可能会有很多线程同时去访问getInstance()
                    LazyThree obj = LazyThree.getInstance();//必然会调用，可能会有很多线程同时去访问getInstance()
                    System.out.println(System.currentTimeMillis()+"===" + obj);
                    //syncSet.add(Hungry.getInstance());
                }
            }.start(); //每循环一次，就启动一个线程,具有一定的随机性
            //每次启动一个线程，count --
            latch.countDown();
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));
        //CountDownLatch 并不是这样子用,实际应用场景中不要学老师这样投机取巧
    }

}
