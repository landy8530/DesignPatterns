package org.landy.proxy.jdk2;

/**
 * @author landyl
 * @create 10:32 AM 07/13/2018
 */
public class AdminProxy  implements Manager {
    private Admin admin;

    public AdminProxy(Admin admin) {
        super();
        this.admin = admin;
    }

    public void doSomething() {
        System.out.println("Log:admin操作开始");
        admin.doSomething();
        System.out.println("Log:admin操作结束");
    }
}

//    //4.测试代码
//    Admin admin = new Admin();
//    Manager m = new AdminPoly(admin);
//        m.doSomething();
