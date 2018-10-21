package org.landy.proxy.jdk2;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Constructor;

/**
 * JDK java.lang.reflect.Proxy的模拟
 *
 * 可以看到生成的代理类是继承了Proxy类的，这就是说明了为什么使用JDK动态代理不能实现继承式动态代理，原因是Java不允许多继承，而生成的代理类本身就已经继承了Proxy类。
 * 至此，JDK的动态代理的使用及底层原理分析完毕，揭下动态代理的神秘面纱，果然是枚美女。
 * 至于最底层的native方法是怎么动态生成代理类的字节码我们也可以简单的模拟一下，先分析下模拟的步骤：首先要生成一段代理类的源码，然后将源码编译后生成代理类的实例返回给调用者。依据此步骤开始编写我们的模拟代码。
 * @author Landyl
 * @create 10:28 AM 07/13/2018
 */
public class Proxy {
    private static final String  RT = "\r\n";
    public static Object newProxyInstance() throws Exception{
        //声明一段源码
        String sourceCode =
                "package org.landy.proxy.jdk2.simulate;"+ RT +
                        "import org.landy.proxy.jdk2.Admin;" + RT +
                        "import org.landy.proxy.jdk2.Manager;" + RT +
                        "//以聚合方式实现的代理主题" + RT +
                        "public class $Proxy0 implements Manager {" + RT +
                        "   private Admin admin;" + RT +
                        "   public $Proxy0(Admin admin) {" + RT +
                        "       super();" + RT +
                        "       this.admin= admin;" + RT +
                        "   }" + RT +
                        "   public void doSomething() {" + RT +
                        "       System.out.println(\"Log:admin操作开始....\");" + RT +
                        "       admin.doSomething();" + RT +
                        "       System.out.println(\"Log:admin操作结束....\");" + RT +
                        "   }" + RT +
                        "}";
        String filename = System.getProperty("user.dir") + "/src/main/java/org/landy/proxy/jdk2/simulate/$Proxy0.java";
        File file = new File(filename);
        //使用org.apache.commons.io.FileUtils.writeStringToFile()将源码写入磁盘
        //编写到处，可以运行一下程序，可以在当前目录中看到生成的.java文件
        FileUtils.writeStringToFile(file,sourceCode);
        //获得当前系统中的编译器
        JavaCompiler complier = ToolProvider.getSystemJavaCompiler();
        //获得文件管理者
        StandardJavaFileManager fileMgr =complier.getStandardFileManager(null, null, null);
        Iterable its =fileMgr.getJavaFileObjects(filename);
        //编译任务
        JavaCompiler.CompilationTask task = complier.getTask(null, fileMgr, null, null, null, its);
        //开始编译，执行完可在当前目录下看到.class文件
        task.call();
        fileMgr.close();
        //load到内存
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class cls = loader.loadClass("org.landy.proxy.jdk2.simulate.$Proxy0");
        //生成代理类对象
        Constructor ct = cls.getConstructor(Admin.class);
        return ct.newInstance(new Admin());
    }
}
class test{
    public static void main(String[] args) throws Exception {
        Manager m = (Manager)Proxy.newProxyInstance();
        m.doSomething();
    }
}
