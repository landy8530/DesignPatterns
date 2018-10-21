package test;

import org.junit.runner.RunWith;
import org.landy.web.config.ApplicationConfigure;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Landy on 2018/5/13.
 */
//@ContextConfiguration(locations = { "classpath:spring.xml" }) //加载配置文件
@ContextConfiguration(classes = ApplicationConfigure.class)
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
//------------如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上///控制事务，参见下一个实例
//这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
//@Transactional
//这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时//指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//------------

//解释下用到的注解:
//@RunWith：用于指定junit运行环境，是junit提供给其他框架测试环境接口扩展，为了便于使用spring的依赖注入，spring提供了org.springframework.test.context.junit4.SpringJUnit4ClassRunner作为Junit测试环境
//@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring/buyer/applicationContext-service.xml"})
//导入配置文件，这里我的applicationContext配置文件是根据模块来分类的。如果有多个模块就引入多个“applicationContext-service.xml”文件。如果所有的都是写在“applicationContext。xml”中则这样导入：
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！
//@Transactional:这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
//AbstractTransactionalDataSourceSpringContextTests要想构建这一系列的无污染纯绿色事务测试框架就必须找到这个基类！（即所有事务均不生效）
public class SpringTestBase extends AbstractJUnit4SpringContextTests {
}
