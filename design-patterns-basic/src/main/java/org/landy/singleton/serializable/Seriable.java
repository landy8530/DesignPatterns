package org.landy.singleton.serializable;

import java.io.Serializable;

/**
 *
 //反序列化时导致单例破坏
 * Created by Landy on 2018/8/21.
 */
public class Seriable implements Serializable {
    //序列化就是说把内存中的状态通过转换成字节码的形式
    //从而转换一个IO流，写入到其他地方(可以是磁盘、网络IO)
    //内存中状态给永久保存下来了

    //反序列化
    //将已经持久化的字节码内容，转换为IO流
    //通过IO流的读取，进而将读取的内容转换为Java对象
    //在转换过程中会重新创建对象new


    public  final static Seriable INSTANCE = new Seriable();
    private Seriable(){}

    public static  Seriable getInstance(){
        return INSTANCE;
    }

    //序列化与反序列化单例一致的话，必须重写此方法
    private  Object readResolve(){
        return  INSTANCE;
    }

}
