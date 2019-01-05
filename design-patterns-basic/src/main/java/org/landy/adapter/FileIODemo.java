package org.landy.adapter;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by Landy on 2019/1/5.
 */
public class FileIODemo {

    public static void main(String[] args) throws Exception {
        //适配接口和被适配接口没有层次关系
        //目前拥有的对象
        InputStream is = new FileInputStream("abc.txt");
        //需要的对象
        Reader reader = new InputStreamReader(is,"UTF-8");

        print(reader);
    }

    private static void print(Reader reader) {

    }
}
