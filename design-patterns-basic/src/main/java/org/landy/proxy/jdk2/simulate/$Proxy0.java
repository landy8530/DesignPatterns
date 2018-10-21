package org.landy.proxy.jdk2.simulate;
import org.landy.proxy.jdk2.Admin;
import org.landy.proxy.jdk2.Manager;
//以聚合方式实现的代理主题
public class $Proxy0 implements Manager {
   private Admin admin;
   public $Proxy0(Admin admin) {
       super();
       this.admin= admin;
   }
   public void doSomething() {
       System.out.println("Log:admin操作开始....");
       admin.doSomething();
       System.out.println("Log:admin操作结束....");
   }
}