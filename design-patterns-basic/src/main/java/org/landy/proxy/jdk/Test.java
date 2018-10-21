package org.landy.proxy.jdk;

import org.landy.proxy.common.IUserDao;
import org.landy.proxy.common.UserDao;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * 动态代理：代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理
 * @author landyl
 * @create 9:45 AM 07/13/2018
 */
public class Test {

    public static void main(String[] args) throws Exception {

        // 目标对象
        IUserDao target = new UserDao();
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());


        //原理：
        //1、拿到被代理对象的引用，并且获取到它的所有的接口，反射获取
        //2、JDK Proxy类重新生成一个新的类、同时新的类要实现被代理类所有实现的所有的接口
        //3、动态生成Java代码，把新加的业务逻辑方法由一定的逻辑代码去调用（在代码中体现）
        //4、编译新生成的Java代码.class
        //5、再重新加载到JVM中运行
        //以上这个过程就叫字节码重组

        //JDK中有个规范，只要要是$开头的一般都是自动生成的

        //通过反编译工具可以查看源代码
        byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{IUserDao.class});
        FileOutputStream os = new FileOutputStream("D://$Proxy0.class");
        os.write(bytes);
        os.close();


        // 执行方法   【代理对象】
        proxy.save();
    }

}
