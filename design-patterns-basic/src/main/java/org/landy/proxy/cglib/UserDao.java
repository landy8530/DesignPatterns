package org.landy.proxy.cglib;

/**
 * CgLib代理：目标对象,没有实现任何接口
 * @author landyl
 * @create 9:46 AM 07/13/2018
 */
public class UserDao {

    public void save() {
        System.out.println("----已经保存数据!----");
    }

}
