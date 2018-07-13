package org.landy.proxy.jdk2;

/**
 * @author landyl
 * @create 10:30 AM 07/13/2018
 */
/**方式一：聚合式静态代理
 * @author Goser    (mailto:goskalrie@163.com)
 * @Since 2016年9月7日
 */
//1.抽象主题接口
public interface Manager {
    void doSomething();
}

//方式二：继承式静态代理
//与上面的方式仅代理类和测试代码不同
//1.代理类
//public class AdminProxy extends Admin {
//    @Override
//    public void doSomething() {
//        System.out.println("Log:admin操作开始");
//        super.doSomething();
//        System.out.println("Log:admin操作开始");
//    }
//}
//    //2.测试代码
//    AdminProxy proxy = new AdminProxy();
//        proxy.doSomething();

