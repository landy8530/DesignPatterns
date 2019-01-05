package org.landy.decorator.io;

import java.io.*;

/**
 * Created by Landy on 2019/1/5.
 */
public class DecoratorDemo {

    public static void main(String[] args) throws Exception {
        //装饰者和被装饰者接口有层次关系
        //目前拥有的对象,被装饰者
        InputStream is = new FileInputStream("abc.txt");
        //装饰者
        FilterInputStream fis = new DataInputStream(is);


    }


}
