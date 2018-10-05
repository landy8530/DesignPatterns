# DesignPatterns for Java

# Table of Contents

* [设计模式简介](#设计模式简介)
  * [1. 单例模式](#1-单例模式)
    * [1.1 线程安全](#11-线程安全)
    * [1.2 单例的实现](#12-单例的实现)
      * [1.2.1 饿汉式](#121-饿汉式)
      * [1.2.2 懒汉式](#122-懒汉式)
      * [1.2.3 注册式](#123-注册式)
        * [1.2.3.1 利用枚举方式实现](#1231-利用枚举方式实现)
        * [1.2.3.2 利用Map方式实现](#1232-利用map方式实现)
      * [1.2.4 序列化与反序列化](#124-序列化与反序列化)
  * [2. 责任链模式](#2-责任链模式)
    * [2.1 概念](#21-概念)
    * [2.2 模式结构](#22-模式结构)
    * [2.3 优点](#23-优点)
    * [2.4 纯与不纯](#24-纯与不纯)
    * [2.5 demo](#25-demo)
  * [3. 策略模式](#3-策略模式)
    * [3.1 概念](#31-概念)
    * [3.2 使用场景](#32-使用场景)
    * [3.3 策略模式涉及到的角色](#33-策略模式涉及到的角色)
    * [3.4 基本特点](#34-基本特点)
    * [3.5 demo](#35-demo)
  * [4. 模板方法模式](#4-模板方法模式)
    * [4.1 概念](#41-概念)
    * [4.2 模版方法模式与策略模式比较](#42-模版方法模式与策略模式比较)
    * [4.3 实现方式](#43-实现方式)
      * [4.3.1 继承方式](#431-继承方式)
      * [4.3.2 回调接口方式](#432-回调接口方式)
    * [4.4 demo](#44-demo)
      * [4.4.1 继承方式](#441-继承方式)
      * [4.4.2 回调接口方式](#442-回调接口方式)
  * [5. 工厂方法模式](#5-工厂方法模式)
    * [5.1 概念](#51-概念)
    * [5.2 特点](#52-特点)
    * [5.3 工厂方法模式的扩展](#53-工厂方法模式的扩展)
      * [5.3.1 简单工厂模式](#531-简单工厂模式)
        * [5.3.1.1 应用场景](#5311-应用场景)
      * [5.3.2 升级为多个工厂类](#532-升级为多个工厂类)
        * [5.3.2.1 应用场景](#5321-应用场景)
      * [5.3.3 替代单例模式](#533-替代单例模式)
        * [5.3.3.1 应用场景](#5331-应用场景)
      * [5.3.4 延迟初始化](#534-延迟初始化)
    * [5.4 总结](#54-总结)
  * [6. 抽象工厂模式](#6-抽象工厂模式)
    * [6.1 概念](#61-概念)
    * [6.2 抽象工厂模式优点](#62-抽象工厂模式优点)
    * [6.2 应用场景](#62-应用场景)
  * [7. 建造者模式](#7-建造者模式)
    * [7.1 概念](#71-概念)
    * [7.2 作用](#72-作用)
    * [7.3 解决的问题](#73-解决的问题)
    * [7.4 实现步骤](#74-实现步骤)
    * [7.5 优缺点](#75-优缺点)
      * [7.5.1 优点](#751-优点)
      * [7.5.2 缺点](#752-缺点)
    * [7.6 应用场景](#76-应用场景)
    * [7.7 demo](#77-demo)
  * [8 代理模式](#8-代理模式)
    * [8.1 静态代理](#81-静态代理)
    * [8.2 动态代理](#82-动态代理)
    * [8.3 CgLib代理](#83-cglib代理)
  * [9. 装饰模式](#9-装饰模式)
    * [9.1 模式动机](#91-模式动机)
    * [9.2 模式定义](#92-模式定义)
    * [9.3 模式结构](#93-模式结构)
    * [9.4 应用场景](#94-应用场景)
  * [10 原型模式](#10-原型模式)
    * [10.1 概念](#101-概念)
    * [10.2 应用场景](#102-应用场景)
    * [10.3 案例](#103-案例)
  * [11 委派模式](#11-委派模式)
    * [11.1 概念](#111-概念)
    * [11.2 特点](#112-特点)
    * [11.3 应用场景](#113-应用场景)
* [设计模式综合运用](#设计模式综合运用)
  * [1. 门面+模版方法+责任链+策略](#1-门面模版方法责任链策略)
    * [1.1 项目背景](#11-项目背景)
    * [1.2 校验逻辑](#12-校验逻辑)
    * [1.3 实现细节](#13-实现细节)
      * [1.3.1 domain介绍](#131-domain介绍)
      * [1.3.2 WorkflowEnum枚举策略](#132-workflowenum枚举策略)
      * [1.3.3 涉及到的设计模式实现思路](#133-涉及到的设计模式实现思路)
        * [1.3.3.1 门面模式](#1331-门面模式)
        * [1.3.3.2 模版方法模式](#1332-模版方法模式)
        * [1.3.3.3 责任链模式](#1333-责任链模式)
        * [1.3.3.4 策略模式](#1334-策略模式)
  * [2. 门面+模版方法+责任链+策略+工厂方法](#2-门面模版方法责任链策略工厂方法)
    * [2.1 项目背景](#21-项目背景)
      * [2.1.1 项目简介](#211-项目简介)
      * [2.1.2 流程梳理](#212-流程梳理)
        * [2.1.2.1 查询抽象模型](#2121-查询抽象模型)
        * [2.1.2.2 组合主键查询策略](#2122-组合主键查询策略)
        * [2.1.2.3 组合主键查询责任链](#2123-组合主键查询责任链)
    * [2.2 Java注解简介](#22-java注解简介)
      * [2.2.1 元注解](#221-元注解)
      * [2.2.2 自定义注解](#222-自定义注解)
      * [2.2.3 使用注解](#223-使用注解)
    * [2.3 策略模式升级版](#23-策略模式升级版)
      * [2.3.1 策略模式实现方式](#231-策略模式实现方式)
      * [2.3.2 注解方式优点](#232-注解方式优点)
      * [2.3.3 组合主键查询策略](#233-组合主键查询策略)
      * [2.3.4 策略工厂](#234-策略工厂)
  * [3. 动态代理+Spring AOP](#3-动态代理spring-aop)
      * [3.1 Spring AOP](#31-spring-aop)
        * [3.1.1 Spring AOP原理](#311-spring-aop原理)
        * [3.1.2 Spring AOP配置](#312-spring-aop配置)
          * [3.1.2.1 XML配置](#3121-xml配置)
          * [3.1.2.2 注解配置](#3122-注解配置)
          * [3.1.2.3 依赖包](#3123-依赖包)
          * [3.1.2.4 配置单元测试](#3124-配置单元测试)
      * [3.2 项目演示](#32-项目演示)
        * [3.2.1 逻辑梳理](#321-逻辑梳理)
        * [3.2.2 逻辑测试](#322-逻辑测试)
          * [3.2.2.1 JDK动态代理](#3221-jdk动态代理)
          * [3.2.2.2 CGLib动态代理](#3222-cglib动态代理)
          * [3.2.2.3 综合测试](#3223-综合测试)
        * [3.2.3 常见问题](#323-常见问题)    
    
# 设计模式简介

设计模式是用来解决复杂问题的，把复杂问题简单化，不要生搬硬套，不要把简单问题复杂化。

## 1. 单例模式

### 1.1 线程安全

内部类实现线程安全的单例模式

### 1.2 单例的实现

常用单例模式写法：饿汉式、懒汉式、注册式、序列化。 

#### 1.2.1 饿汉式

在实例使用之前，不管你用不用，我都先new出来再说，避免了线程安全的问题

#### 1.2.2 懒汉式

默认加载的时候不实例化，在需要使用的时候实例化（Spring中叫做：延时加载）

特点：在外部类被调用的时候内部类才会被加载，内部类一定是要在方法调用之前初始化，巧妙地避免了线程安全问题，这种形式兼顾饿汉式的内存浪费，也兼顾synchronized性能问题

#### 1.2.3 注册式

每使用一次，都往一个固定容器中去注册并且将使用过的对象进行缓存，下次去取对象的时候就直接从缓存中取出，以保证每次取出的对象一致。
IOC的单例模式就是注册登记式的单例模式。

##### 1.2.3.1 利用枚举方式实现

##### 1.2.3.2 利用Map方式实现

#### 1.2.4 序列化与反序列化

必须重写以下方法
```
private  Object readResolve(){
    return  INSTANCE;
}
```

## 2. 责任链模式
### 2.1 概念

一个请求有多个对象来处理，这些对象形成一条链，根据条件确定具体由谁来处理，如果当前对象不能处理则传递给该链中的下一个对象，直到有对象处理它为止。
责任链模式通过将请求和处理分离开来，以进行解耦。职责链模式结构的核心在于引入了一个抽象处理者。

职责链模式通过建立一条链来组织请求的处理者，请求将沿着链进行传递，请求发送者无须知道请求在何时、何处以及如何被处理，实现了请求发送者与处理者的解耦。
在软件开发中，如果遇到有多个对象可以处理同一请求时可以应用职责链模式，例如在Web应用开发中创建一个过滤器(Filter)链来对请求数据进行过滤，
在工作流系统中实现公文的分级审批等等，使用职责链模式可以较好地解决此类问题。

### 2.2 模式结构

Handler（抽象处理者）： 定义一个处理请求的接口，提供对后续处理者的引用
ConcreteHandler（具体处理者）： 抽象处理者的子类，处理用户请求，可选将请求处理掉还是传给下家；在具体处理者中可以访问链中下一个对象，以便请求的转发。

### 2.3 优点

降低耦合度，分离了请求与处理，无须知道是哪个对象处理其请求
简化对象的相互连接，仅保持一个指向后者的引用，而不需保持所有候选接受者的引用
扩展容易，新增具体请求处理者，只需要在客户端重新建链即可，无需破坏原代码

### 2.4 纯与不纯

纯：要么承担全部责任，要么将责任推给下家，不允许出现某一个具体处理者对象在承担了一部分或全部责任后又将责任向下传递的情况。

不纯：允许某个请求被一个具体处理者部分处理后再向下传递，或者一个具体处理者处理完某请求后其后继处理者可以继续处理该请求，而且一个请求可以最终不被任何处理者对象所接收。

一个纯的责任链模式：

要求一个具体的处理者对象只能在两个行为中选择一个：一是承担责任，而是把责任推给下家。不允许出现某一个具体处理者对象在承担了一部分责任后又把责任向下传的情况。在一个纯的责任链模式里面，一个请求必须被某一个处理者对象所接收；

一个不纯的责任链模式：

一个请求可以最终不被任何接收端对象所接收。纯的责任链模式的实际例子很难找到，一般看到的例子均是不纯的责任链模式的实现。

### 2.5 demo

demo1:

   客户端创建了三个处理者对象，并指定第一个处理者对象的下家是第二个处理者对象，第二个处理者对象的下家是第三个处理者对象。然后客户端将请求传递给第一个处理者对象。

demo2:

1. 用Filter模拟处理Request、Response
2. 思路细节技巧：

(1) Filter的doFilter方法改为doFilter(Request,Resopnse,FilterChain),有FilterChain引用，为利用FilterChain调用下一个Filter做准备。

(2) FilterChain继承Filter,这样，FilterChain既是FilterChain又是Filter,那么FilterChain就可以调用Filter的方法doFilter(Request,Resopnse,FilterChain)。

(3) FilterChain的doFilter(Request,Resopnse,FilterChain)中，有index标记了执行到第几个Filter,当所有Filter执行完后request处理后，就会return,以倒序继续执行response处理。

## 3. 策略模式

OOP三个基本特征是:封装、继承、多态。通过继承，我们可以基于差异编程，也就是说，对于一个满足我们大部分需求的类，可以创建它的一个子类并只改变我们不期望的那部分。
但是在实际使用中，继承很容易被过度使用，并且过度使用的代价是比较高的，所以我们减少了继承的使用，使用组合或委托代替。策略模式使用委托的方式。

### 3.1 概念

策略模式定义了一系列的算法，并将每一个算法封装起来，而且使他们可以相互替换，让算法独立于使用它的客户而独立变化。

分析下定义，策略模式定义和封装了一系列的算法，它们是可以相互替换的，也就是说它们具有共性，而它们的共性就体现在策略接口的行为上，
另外为了达到最后一句话的目的，也就是说让算法独立于使用它的客户而独立变化，我们需要让客户端依赖于策略接口。

### 3.2 使用场景

比较器，旅行路线，固定算法，结算支付方式，登录等，根据用户的需求处理数据的时候需要对算法做出选择（固定的算法，不需要改变的），客户已经有选择，不需要知道算法的具体细节。
1. 针对同一类型问题的多种处理方式，仅仅是具体行为有差别时；
2. 需要安全地封装多种同一类型的操作时；
3. 出现同一抽象类有多个子类，而又需要使用 if-else 或者 switch-case 来选择具体子类时。

通常会结合抽象工厂模式进行使用。

### 3.3 策略模式涉及到的角色

1. 环境(Context)角色：持有一个Strategy的引用。
2. 抽象策略(Strategy)角色：这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口。
3. 具体策略(ConcreteStrategy)角色：包装了相关的算法或行为。

### 3.4 基本特点

1. 最终执行结果是固定的
2. 执行过程和执行逻辑不一样

### 3.5 demo

demo1:简单的使用工厂进行封装策略
demo2:使用注解动态配置策略
pay:具体支付场景

## 4. 模板方法模式

### 4.1 概念

定义一个算法的骨架，将骨架中的特定步骤延迟到子类中。模板方法模式使得子类可以不改变算法的结构即可重新定义该算法的某些特定步骤。

### 4.2 模版方法模式与策略模式比较

1. 策略模式：只有选择权（由用户自定义选择已有的算法）
2. 模版模式：侧重点不是选择，你没得选择，你必须这么做。但是你可以参与其中某部分的内容

### 4.3 实现方式

#### 4.3.1 继承方式

继承方式是常见方式，模板方法模式展示了经典重用的一种形式，通用算法被放在基类中，通过继承在不同的子类中实现该通用算法。

参见[4.4.1 继承方式](#441-继承方式)

#### 4.3.2 回调接口方式

Template Method模式一般是需要继承的。这里想要探讨另一种对Template Method的理解。
Spring中的JdbcTemplate，在用这个类时并不想去继承这个类，因为这个类的方法太多，但是我们还是想用到JdbcTemplate已有的稳定的、公用的数据库连接，那么我们怎么办呢？我们可以把变化的东西抽出来作为一个参数传入 JdbcTemplate 的方法中。但是变化的东西是一段代码，而且这段代码会用到JdbcTemplate中的变量。怎么办？那我们就用回调对象吧。在这个回调对象中定义一个操纵JdbcTemplate中变量的方法，我们去实现这个方法，就把变化的东西集中到这里了。然后我们再传入这个回调对象到JdbcTemplate，从而完成了调用。这就是Template Method不需要继承的另一种实
现方式。

参见[4.4.2 回调接口方式](#442-回调接口方式)

### 4.4 demo

#### 4.4.1 继承方式


我们通过定义通用类BubbleSorter，把冒泡排序的算法骨架放在基类，然后实现不同的子类分别对int数组、double数组、List集合进行排序。但这样是有代价的，因为继承是非常强的关系，派生类不可避免地与基类绑定在一起了。但如果我现在需要用快速排序而不是冒泡排序来进行排序，
但快速排序却没有办法重用setArray、getLength、needSwap和swap方法了。不过，策略模式提供了另一种可选的方案。

事例代码包：org.landy.template.method.sort

#### 4.4.2 回调接口方式
    
JdbcTemplate

事例代码包：org.landy.template.method.jdbc    

## 5. 工厂方法模式

工厂方法模式（Factory）允许我们只依赖于抽象接口就能创建出具体对象的实例，所以在开发中，如果具体类是高度易变的，那么该模式就非常有用。

### 5.1 概念

定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到子类。

### 5.2 特点

1. 良好的封装性，代码结构清晰。
2. 扩展性好，比如增加一个“产品类”的情况下，只要适当修改工厂类或者扩展出一个工厂类即可。
3. 屏蔽“产品类”，工厂只关心产品的接口，只要接口不变，系统的上层模块就不会发生变化。
4. 工厂方法是典型的解耦框架。

### 5.3 工厂方法模式的扩展

#### 5.3.1 简单工厂模式

又称为静态工厂方法(Static Factory Method)模式，不属于 23 种设计模式之一，它属于类创建型模式（同属于创建型模式的还有工厂方法模式，抽象工厂模式，单例模式，建造者模式）。
在简单工厂模式中，可以根据参数的不同返回不同类的实例。简单工厂模式专门定义一个类来负责创建其他类的实例，被创建的实例通常都具有共同的父类。

##### 5.3.1.1 应用场景
简单工厂模式的实质是由一个工厂类根据传入的参数，动态决定应该创建哪一个产品类。 Spring 中的 BeanFactory 就是简单工厂模式的体现，根据传入一个唯一的标识来获得 Bean 对象，但 是否是在传入参数后创建还是传入参数前创建这个要根据具体情况来定。


#### 5.3.2 升级为多个工厂类

工厂方法模式把简单工厂模式的内部逻辑判断移到了客户端，把每个“产品类”的实现方式都定义一个工厂类的方式。

##### 5.3.2.1 应用场景
通常由应用程序直接使用 new 创建新的对象，为了将对象的创建和使用相分离，采用工厂模 式,即应用程序将对象的创建及初始化职责交给工厂对象。 
一般情况下,应用程序有自己的工厂对象来创建 Bean.如果将应用程序自己的工厂对象交给 Spring 管 理,那么 Spring 管理的就不是普通的 Bean,而是工厂 Bean。

#### 5.3.3 替代单例模式

单例模式的核心是只在内存中保存一个对象，通过工厂方法模式也可以只在内存中生成一个对象。

```
public class SingletonFactory {

    private static Singleton singleton;

    static {
        try {
            Class cl = Class.forName(Singleton.class.getName());
            //获得无参构造
            Constructor constructor = cl.getDeclaredConstructor();
            //设置无参构造是可访问的
            constructor.setAccessible(true);
            //实例化
            singleton = (Singleton) constructor.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Singleton getSingleton() {
        return singleton;
    }

}
```

##### 5.3.3.1 应用场景

保证一个类仅有一个实例，并提供一个访问它的全局访问点。 Spring 中的单例模式完成了后半句话，即提供了全局的访问点 BeanFactory。但没有从构造器级别去 控制单例，这是因为 Spring 管理的是是任意的 Java 对象。 Spring 下默认的 Bean 均为单例

#### 5.3.4 延迟初始化

延迟初始化：一个对象被消费完毕后，并不立刻释放，工厂类保持其初始状态，等待再次被调用。
延迟初始化是工厂方法模式的一个扩展应用，比如限制一个产品类的最大实例化数量，可以通过工厂类中的Map中已有的对象数量来实现。
比如JDBC的最大连接数量，该数量就是内存中的最大实例化的数量。
延迟加载还可以用在对象初始化比较复杂的情况下，这样可以通过延迟加载降低对象的产生和销毁带来的复杂性。

注：在【设计模式综合运用】中就有用到延迟初始化的功能。

### 5.4 总结

简单工厂模式和工厂方法模式都封装了对象的创建，它们使得高层策略模块在创建类的实例时无需依赖于这些类的具体实现。但是两种工厂模式之间又有差异：

1. 简单工厂模式：最大的优点在于工厂类包含了必要的判断逻辑，根据客户端的条件动态地实例化相关的类。但这也是它的缺点，当扩展功能的时候，需要修改工厂方法，违反了开放封闭原则

2. 工厂方法模式：符合开放封闭原则，但这带来的代价是扩展的时候要增加相应的工厂类，增加了开发量，而且需要修改客户端代码

## 6. 抽象工厂模式

### 6.1 概念

抽象工厂模式是工厂方法模式的升级版本。

### 6.2 抽象工厂模式优点

1. 易于管理（抽象逻辑都集中式管理）
2. 易于扩展

### 6.2 应用场景

Spring BeanFactory

## 7. 建造者模式

### 7.1 概念

将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示

### 7.2 作用

在用户不知道对象的建造过程和细节的情况下就可以直接创建复杂的对象。

1. 用户只需要给出指定复杂对象的类型和内容；
2. 建造者模式负责按顺序创建复杂对象（把内部的建造过程和细节隐藏起来)

### 7.3 解决的问题

1. 方便用户创建复杂的对象（不需要知道实现过程）
2. 代码复用性 & 封装性（将对象构建过程和细节进行封装 & 复用）

### 7.4 实现步骤

1. 指挥者（Director）直接和客户（Client）进行需求沟通；
2. 沟通后指挥者将客户创建产品的需求划分为各个部件的建造请求（Builder）；
3. 将各个部件的建造请求委派到具体的建造者（ConcreteBuilder）；
4. 各个具体建造者负责进行产品部件的构建；
5. 最终构建成具体产品（Product）。

### 7.5 优缺点
在全面解析完后，我来分析下其优缺点：

#### 7.5.1 优点

1. 易于解耦
将产品本身与产品创建过程进行解耦，可以使用相同的创建过程来得到不同的产品。也就说细节依赖抽象。
2. 易于精确控制对象的创建
将复杂产品的创建步骤分解在不同的方法中，使得创建过程更加清晰
3. 易于拓展
增加新的具体建造者无需修改原有类库的代码，易于拓展，符合“开闭原则“。
每一个具体建造者都相对独立，而与其他的具体建造者无关，因此可以很方便地替换具体建造者或增加新的具体建造者，用户使用不同的具体建造者即可得到不同的产品对象。

#### 7.5.2 缺点

建造者模式所创建的产品一般具有较多的共同点，其组成部分相似；如果产品之间的差异性很大，则不适合使用建造者模式，因此其使用范围受到一定的限制。
如果产品的内部变化复杂，可能会导致需要定义很多具体建造者类来实现这种变化，导致系统变得很庞大。

### 7.6 应用场景

1. 需要生成的产品对象有复杂的内部结构，这些产品对象具备共性；

2. 隔离复杂对象的创建和使用，并使得相同的创建过程可以创建不同的产品。

### 7.7 demo

实际项目中的一个案例：系统集成中，需要把客户传过来的数据进行封装处理，然后统一交给后端系统处理，然后集成到自己的业务系统中。
假设集成过来的数据有以下几部分组成：

1. 用户信息（user_profile）
2. 订单计划信息（plan）
3. 订单信息（order）
4. 订单成员信息（member)
5. ...

由于实际业务系统太过复杂，这边就简化为以上四个部分，实际业务中Builder中的方法都有相应的返回类型，这里直接简单些为void，然后实现为控制台输出。

具体实现参见代码部分即可。

## 8 代理模式

代理(Proxy)是一种设计模式,提供了对目标对象另外的访问方式;即通过代理对象访问目标对象.这样做的好处是:可以在目标对象实现的基础上,增强额外的功能操作,即扩展目标对象的功能.
这里使用到编程中的一个思想:不要随意去修改别人已经写好的代码或者方法,如果需改修改,可以通过代理的方式来扩展该方法

举个例子来说明代理的作用:

1. 假设我们想邀请一位明星,那么并不是直接连接明星,而是联系明星的经纪人,来达到同样的目的.明星就是一个目标对象,他只要负责活动中的节目,而其他琐碎的事情就交给他的代理人(经纪人)来解决.这就是代理思想在现实中的一个例子。

2. 考虑这样的场景，管理员在网站上执行操作，在生成操作结果的同时需要记录操作日志，这是很常见的。此时就可以使用代理模式，代理模式可以通过聚合和继承两种方式实现。

代理模式的关键点是:代理对象与目标对象.代理对象是对目标对象的扩展,并会调用目标对象

### 8.1 静态代理

静态代理在使用时,需要定义接口或者父类,被代理对象与代理对象一起实现相同的接口或者是继承相同父类.

下面举个案例来解释:
模拟保存动作,定义一个保存动作的接口:IUserDao.java,然后目标对象实现这个接口的方法UserDao.java,此时如果使用静态代理方式,就需要在代理对象(UserDaoProxy.java)中也实现IUserDao接口.调用的时候通过调用代理对象的方法来调用目标对象.
需要注意的是,代理对象与目标对象要实现相同的接口,然后通过调用相同的方法来调用目标对象的方法。

静态代理总结:
1.可以做到在不修改目标对象的功能前提下,对目标功能扩展.
2.缺点:

因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护.
如何解决静态代理中的缺点呢?答案是可以使用动态代理方式。

具体实现参见代码部分即可。

### 8.2 动态代理

动态代理有以下特点:
1.代理对象,不需要实现接口
2.代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型)
3.动态代理也叫做:JDK代理,接口代理

JDK中生成代理对象的API
代理类所在包:java.lang.reflect.Proxy
JDK实现代理只需要使用newProxyInstance方法,但是该方法需要接收三个参数,完整的写法是:

```
static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler h )
```

注意该方法是在Proxy类中是静态方法,且接收的三个参数依次为:

1. ClassLoader loader:指定当前目标对象使用类加载器,获取加载器的方法是固定的
2. Class<?>[] interfaces:目标对象实现的接口的类型,使用泛型方式确认类型
3. InvocationHandler h: 事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入

代码示例:
接口类IUserDao.java以及接口实现类,目标对象UserDao是一样的,没有做修改.在这个基础上,增加一个代理工厂类(ProxyFactory.java),将代理类写在这个地方,然后在测试类(需要使用到代理的代码)中先建立目标对象和代理对象的联系,然后代用代理对象的中同名方法。

JDK中动态代理实现的步骤为：
1. 创建代理类的源码；
2. 对源码进行编译成字节码；
3. 将字节码加载到内存；
4. 实例化代理类对象并返回给调用者；

总结:
代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理

### 8.3 CgLib代理

上面的静态代理和动态代理模式都是要求目标对象是实现一个接口的目标对象,但是有时候目标对象只是一个单独的对象,并没有实现任何的接口,这个时候就可以使用以目标对象子类的方式类实现代理,这种方法就叫做:Cglib代理

Cglib代理,也叫作子类代理,它是在内存中构建一个子类对象从而实现对目标对象功能的扩展.

1. JDK的动态代理有一个限制,就是使用动态代理的对象必须实现一个或多个接口,如果想代理没有实现接口的类,就可以使用Cglib实现.
2. Cglib是一个强大的高性能的代码生成包,它可以在运行期扩展java类与实现java接口.它广泛的被许多AOP的框架使用,例如Spring AOP和synaop,为他们提供方法的interception(拦截)
3. Cglib包的底层是通过使用一个小而块的字节码处理框架ASM来转换字节码并生成新的类.不鼓励直接使用ASM,因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉.

Cglib子类代理实现方法:
1. 需要引入cglib的jar文件,但是Spring的核心包中已经包括了Cglib功能,所以直接引入spring-core-4.2.3.jar即可.
2. 引入功能包后,就可以在内存中动态构建子类
3. 代理的类不能为final,否则报错
4. 目标对象的方法如果为final/static,那么就不会被拦截,即不会执行目标对象额外的业务方法.

在Spring的AOP编程中:
1. 如果加入容器的目标对象有实现接口,用JDK代理
2. 如果目标对象没有实现接口,用Cglib代理

CGLIB代理总结：
1. CGLIB创建的动态代理对象比JDK创建的动态代理对象的性能更高，但是CGLIB创建代理对象时所花费的时间却比JDK多得多。所以对于单例的对象，因为无需频繁创建对象，用CGLIB合适，反之使用JDK方式要更为合适一些。
2. 同时由于CGLib由于是采用动态创建子类的方法，对于final修饰的方法无法进行代理。

## 9. 装饰模式

### 9.1 模式动机

一般有两种方式可以实现给一个类或对象增加行为：

继承机制，使用继承机制是给现有类添加功能的一种有效途径，通过继承一个现有类可以使得子类在拥有自身方法的同时还拥有父类的方法。但是这种方法是静态的，用户不能控制增加行为的方式和时机。
关联机制，即将一个类的对象嵌入另一个对象中，由另一个对象来决定是否调用嵌入对象的行为以便扩展自己的行为，我们称这个嵌入的对象为装饰器(Decorator)
装饰模式以对客户透明的方式动态地给一个对象附加上更多的责任，换言之，客户端并不会觉得对象在装饰前和装饰后有什么不同。装饰模式可以在不需要创造更多子类的情况下，将对象的功能加以扩展。这就是装饰模式的模式动机。

### 9.2 模式定义

装饰模式的定义是：装饰模式又名包装(Wrapper)模式。装饰模式以对客户端透明的方式扩展对象的功能，是继承关系的一个替代方案。

### 9.3 模式结构

装饰模式包含如下角色：

Component: 抽象构件
ConcreteComponent: 具体构件
Decorator: 抽象装饰类
ConcreteDecorator: 具体装饰类

### 9.4 应用场景

装饰器模式的应用场景：

1. 需要扩展一个类的功能。
2. 动态的为一个对象增加功能，而且还能动态撤销。（继承不能做到这一点，继承的功能是静态的，不能动态增删。）

缺点：产生过多相似的对象，不易排错！

## 10. 原型模式

### 10.1 概念

所谓原型模式，就是 Java 中的克隆技术，以某个对象为原型。复制出新的对象。显然新的对象具备原 型对象的特点，效率高（避免了重新执行构造过程步骤）。数据内容相同，但对象实例不同（完全两个个体）

### 10.2 应用场景

原型模式就是从一个对象再创建另外一个可定制的对象，而且不需要知道任何创建的细节。 

### 10.3 案例

1. Apache BeanUtils利用反射实现对象属性值的复制，就是利用了原型模式。
2. Spring中的原型模式：把对象中的依赖关系，在每次使用对象之前，都会创建一个新的对象，并且将依赖关系完整的复制给新创建的对象。（scope="prototype"）
```
Spring 默认是采用单例模式
```

## 11 委派模式

### 11.1 概念

不属于23种设计模式之一，是面向对象设计模式中常用的一种模式，有点像静态代理模式，又有点像策略模式，它是两种设计模式的组合体，常见于Spring源码的实现中。

### 11.2 特点

1. 持有被委托人的引用，只关心结果，不关心过程。
2. 相当于静态代理中的特殊情况，全权代理
3. 代理模式注重的是过程，委派模式注重的是结果
4. 策略模式注重是可扩展（外部扩展），委派模式注重内部的灵活和复用
5. 委派的核心：就是分发、调度、派遣

### 11.3 应用场景

这种模式的原理为类B和类A是两个互相没有任何关系的类，B具有和A一模一样的方法和属性；并且调用B中的方法，属性就是调用A中同名的方法和属性。B好像就是一个受A授权委托的中介。第三方的代码不需要知道A的存在，也不需要和A发生直接的联系，通过B就可以直接使用A的功能，这样既能够使用到A的各种功能，又能够很好的将 A 保护起来了，一举两得。

项目经理：在老板眼里，他只负责干活，实际上是做类似于调度的工作，任务分配等。

重要特征：项目经理在分配任务之前，需要做一个权衡，类似于策略模式。

在Spring中，以Delegate结尾的类，以Dispatcher结尾的类基本上都是委派模式实现。

# 设计模式综合运用

## 1. 门面+模版方法+责任链+策略

### 1.1 项目背景

在公司的一个实际项目中，需要做一个第三方公司（以下简称XHF）的系统集成工作，把该公司的一些订单数据集成到自己公司平台下，各个订单具有一些共性，但是也有其特有的特征。
经过设计，目前我把订单分为POLICY和XHF类型（暂且这么说吧，反正就是一种订单类型，大家参照着看就OK）。

在订单数据集成到公司平台前，需要对订单数据进行一些必要的业务逻辑校验操作，并且每个订单都有自己的校验逻辑（包含公共的校验逻辑）。
本节介绍的便是整个订单集成系统中的校验逻辑在综合利用设计模式的基础上进行架构设计。

### 1.2 校验逻辑

本校验逻辑主要分为四个部分：
1. 校验文件名称（RequestValidator.validateFileInfo）
2. 校验文件内容中的概要部分（RequestValidator.validateSummary）
3. 校验文件内容中的列名称（RequestValidator.validateHeaders）
4. 校验文件内容中的明细（RequestValidator.validateDetails）

其实上面的RequestValidator的实现逻辑最后都是委托给RequestValidationFacade这个门面类进行相应的校验操作。

### 1.3 实现细节

#### 1.3.1 domain介绍

主要分为RequestFile和RequestDetail两个domain,RequestFile接收泛型的类型（即RequestFile<T extends RequestDetail>）,
使得其子类能够自动识别相应的RequestDetail的子类。RequestFile为抽象类，定义了以下抽象方法，由子类实现：

```
//由子类实现具体的获取文件明细内容
public abstract List<T> getRequestDetails();
//由子类实现具体的获取workflow的值
public abstract WorkflowEnum getProcessWorkFlow();
//由子类实现文件列字段名列表
public abstract String[] getDetailHeaders();
```

RequestDetail及其子类就是workflow对应文件的明细内容。

#### 1.3.2 WorkflowEnum枚举策略

本例中如下规定：
1. workflow为WorkflowEnum.POLICY对应文件名为：xhf_policy_yyyyMMdd_HHmmss_count.txt
2. workflow为WorkflowEnum.XHF对应文件名为：xhf_integration_yyyyMMdd_HHmmss_count.txt

以上校验逻辑在AbstractRequestValidation类相应的子类中实现（validateFileName方法），其实这个枚举贯穿整个校验组件，它就是一个针对每个业务流程定义的一个枚举策略。

#### 1.3.3 涉及到的设计模式实现思路

##### 1.3.3.1 门面模式

在客户端调用程序中，采用门面模式进行统一的入口（门面模式讲究的是脱离具体的业务逻辑代码）。门面模式封装的结果就是避免高层模块深入子系统内部，同时提供系统的高内聚、低耦合的特性。

此案例中，门面类为RequestValidationFacade，然后各个门面方法的参数均为抽象类RequestFile，通过RequestFile->getProcessWorkFlow()决定调用AbstractRequestValidation中的哪个子类。
AbstractRequestValidation类构造方法中定义了如下逻辑：

```
requestValidationHandlerMap.put(this.accessWorkflow(),this.accessBeanName());
```

把子类中Spring自动注入的实体bean缓存到requestValidationHandlerMap中，key即为WorkflowEnum枚举值，value为spring bean name,
然后在门面类中可以通过对应的枚举值取得BeanName，进而得到AbstractRequestValidation相应的子类对象，进行相应的校验操作。

注：这边动态调用到AbstractRequestValidation相应的子类对象，其实也是隐藏着【策略模式】的影子。

##### 1.3.3.2 模版方法模式

在具体的校验逻辑中，用到核心设计模式便是模版方法模式，AbstractRequestValidation抽象类中定义了以下抽象方法：
```
    /**
     * validate the file details
     * @param errMsg
     * @param requestFile
     * @return
     */
    protected abstract StringBuilder validateFileDetails(StringBuilder errMsg,RequestFile requestFile);

    /**
     * validate the file name
     * @param fileName
     * @return
     */
    protected abstract String validateFileName(String fileName);

    /**
     * return the current xhf_UPDATE_WORKFLOW.UPDATE_WORKFLOW_ID
     * @return
     */
    protected abstract WorkflowEnum accessWorkflow();

    /**
     * return the current file name's format ,such as: xhf_policy_yyyyMMdd_HHmmss_count.txt
     * @return
     */
    protected abstract String accessFileNameFormat();

    /**
     * return the subclass's spring bean name
     * @return
     */
    protected abstract String accessBeanName();

```

以上抽象方法就类似我们常说的钩子函数，由子类实现即可。

##### 1.3.3.3 责任链模式

在AbstractRequestValidation抽象类中有个抽象方法validateFileDetails，校验的是文件的明细内容中的相应业务规则，此为核心校验，
较为复杂，而且针对每个业务流程，其校验逻辑相差较大，在此处，利用了责任链模式进行处理。

Validator为校验器的父接口，包含两个泛型参数(即：<R extends RequestDetail,F extends RequestFile>)，其实现类可以方便的转换需要校验的文件明细。
```
String doValidate(R detail, F file, ValidatorChain chain) throws BusinessValidationException;
```
该方法含有一个ValidatorChain参数，就自然而然的为该校验器形成一个链条提供便利条件。

ValidatorChain为校验器链，含有两个接口方法：
```
 String doValidate(T requestDetail, F requestFile) throws BusinessValidationException;

 ValidatorChain addValidator(Validator validator, WorkflowEnum workflowId);

```
该处有一个addValidator方法，为ValidatorChain对象添加校验器的方法，返回本身。对应于每个业务流程需要哪些校验器就在此实现即可（即AbstractRequestValidation的子类方法validateFileDetails）。

##### 1.3.3.4 策略模式

如果单单从上面的校验器实现上来看，如果需要增加一个校验器，就需要在AbstractRequestValidation的子类方法validateFileDetails中添加，然后进行相应的校验操作。这样就会非常的麻烦，没有做到真正的解耦。
此时，策略模式就发挥到了可以动态选择某种校验策略的作用（Validator的实现类就是一个具体的校验策略）。

AbstractValidatorHandler抽象类持有FileDetailValidatorChain类的对象，并且实现累Spring的一个接口ApplicationListener（是为了Spring容器启动完成的时候自动把相应的校验器加入到校验器链中）。
核心就是WorkflowEnum这个策略枚举的作用，在子类可以动态的取得相应的校验器对象。

根据子类提供需要的校验器所在的包名列表和不需要的校验器列表，动态配置出需要的校验器链表。核心实现逻辑如下：

```
private void addValidators() {
    List<Class<? extends Validator>> validators = getValidators();

    validators.forEach((validator) -> {
        String simpleName = validator.getSimpleName();
        String beanName = simpleName.substring(0, 1).toLowerCase() + simpleName.substring(1);

        LOGGER.info("Added validator:{},spring bean name is:{}",simpleName,beanName);

        Validator validatorInstance = ApplicationUtil.getApplicationContext().getBean(beanName,validator);

        fileDetailValidatorChain.addValidator(validatorInstance,getWorkflowId());

    });
}
```
具体实现可以参考代码即可。

该类含有以下几个抽象方法：
```
protected abstract WorkflowEnum getWorkflowId();
/**
 * the package need to be added the validators
 * @return
 */
protected abstract Set<String> getBasePackages();

/**
 * the classes need to be excluded
 * @return
 */
protected abstract Set<Class> excludeClasses();

```

## 2. 门面+模版方法+责任链+策略+工厂方法

上一节在实现策略模式的实现上，发现了一个弊端：那就是如果在后续业务发展中，需要再次增加一个业务策略的时候，则需要再次继承`AbstractValidatorHandler`类（详情请参见上篇文章），这样就会造成一定的类膨胀。今天我利用注解的方式改造成动态策略模式，这样就只需要关注自己的业务类即可，无需再实现一个类似的Handler类。

### 2.1 项目背景

#### 2.1.1 项目简介

在公司的一个业务系统中，有这样的一个需求，就是根据不同的业务流程，可以根据不同的组合主键策略进行动态的数据业务查询操作。在本文中，我假设有这样两种业务，客户信息查询和订单信息查询，对应以下枚举类：

```java
/**
 * 业务流程枚举
 * @author landyl
 * @create 11:18 AM 05/07/2018
 */
public enum WorkflowEnum {
    ORDER(2),
    CUSTOMER(3),
    ;
    
}
```

每种业务类型都有自己的组合主键查询规则，并且有自己的查询优先级，比如客户信息查询有以下策略：

1. customerId
2. requestId
3. birthDate+firstName

以上仅是假设性操作，实际业务规则比这复杂的多

#### 2.1.2 流程梳理 

主要业务流程，可以参照以下简单的业务流程图。

##### 2.1.2.1 查询抽象模型

![查询抽象模型](https://github.com/landy8530/DesignPatterns/raw/master/doc/abstractModel.png)

##### 2.1.2.2 组合主键查询策略

![组合主键查询策略](https://github.com/landy8530/DesignPatterns/raw/master/doc/KeyIdentificationStrategy.png)

##### 2.1.2.3 组合主键查询责任链

![组合主键查询责任链](https://github.com/landy8530/DesignPatterns/raw/master/doc/KeyIdentificationChain.png)

### 2.2 Java注解简介

注解的语法比较简单，除了@符号的使用之外，它基本与Java固有语法一致。

#### 2.2.1 元注解

JDK1.5提供了4种标准元注解，专门负责新注解的创建。

| 注解       | 说明                                                         |
| ---------- | ------------------------------------------------------------ |
| @Target    | 表示该注解可以用于什么地方，可能的ElementType参数有：<br/>CONSTRUCTOR：构造器的声明 <br/>FIELD：域声明（包括enum实例）<br/>LOCAL_VARIABLE：局部变量声明<br/>METHOD：方法声明<br/>PACKAGE：包声明<br/>PARAMETER：参数声明<br/>TYPE：类、接口（包括注解类型）或enum声明 |
| @Retention | 表示需要在什么级别保存该注解信息。可选的RetentionPolicy参数包括:<br/>SOURCE：注解将被编译器丢弃<br/>CLASS：注解在class文件中可用，但会被VM丢弃<br/>RUNTIME：JVM将在运行期间保留注解，因此可以通过反射机制读取注解的信息 |
| @Document  | 将注解包含在Javadoc中                                        |
| @Inherited | 允许子类继承父类中的注解                                     |

#### 2.2.2 自定义注解

定义一个注解的方式相当简单，如下代码所示：

```java
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
//使用@interface关键字定义注解
public @interface Description {
    /*
     * 注解方法的定义（其实在注解中也可以看做成员变量）有如下的规定：
     * 1.不能有参数和抛出异常
     * 2.方法返回类型只能为八种基本数据类型和字符串，枚举和注解以及这些类型构成的数组
     * 3.可以包含默认值，通过default实现
     * 4.如果只有一个方法（成员变量），最好命名为value
     */
    String value();
    int count() default 1; //默认值为1
}
```

注解的可用的类型包括以下几种：所有基本类型、String、Class、enum、Annotation、以上类型的数组形式。元素不能有不确定的值，即要么有默认值，要么在使用注解的时候提供元素的值。而且元素不能使用null作为默认值。注解在只有一个元素且该元素的名称是value的情况下，在使用注解的时候可以省略“value=”，直接写需要的值即可。 

#### 2.2.3 使用注解

如上所示的注解使用如下：

```java
/**
 * @author landyl
 * @create 2018-01-12:39 PM
 */
//在类上使用定义的Description注解
@Description(value="class annotation",count=2)
public class Person {
    private String name;
    private int age;

    //在方法上使用定义的Description注解
    @Description(value="method annotation",count=3)
    public String speak() {
        return "speaking...";
    }
}
```

使用注解最主要的部分在于对注解的处理，那么就会涉及到**注解处理器**。从原理上讲，注解处理器就是通过反射机制获取被检查方法上的注解信息，然后根据注解元素的值进行特定的处理。

```java
/**
 * @author landyl
 * @create 2018-01-12:35 PM
 * 注解解析类
 */
public class ParseAnnotation {
    public static void main(String[] args){
        //使用类加载器加载类
        try {
            Class c = Class.forName("com.annatation.Person");//加载使用了定义注解的类
            //找到类上的注解
            boolean isExist = c.isAnnotationPresent(Description.class);
            if(isExist){
                //拿到注解示例
                Description d = (Description)c.getAnnotation(Description.class);
                System.out.println(d.value());
            }
            //找到方法上的注解
            Method[] ms = c.getMethods();
            for(Method m : ms){
                boolean isMExist = m.isAnnotationPresent(Description.class);
                if(isMExist){
                    Description d = m.getAnnotation(Description.class);
                    System.out.println(d.value());
                }
            }
            //另外一种注解方式
            for(Method m:ms){
                Annotation[] as = m.getAnnotations();
                for(Annotation a:as){
                    if(a instanceof Description){
                        Description d = (Description)a;
                        System.out.println(d.value());
                    }
                }

            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
```

### 2.3 策略模式升级版

#### 2.3.1 策略模式实现方式

1. 使用工厂进行简单的封装
2. 使用注解动态配置策略
3. 使用模版方法模式配置策略(参见[1. 门面+模版方法+责任链+策略](#1-门面模版方法责任链策略))
4. 使用工厂+注解方式动态配置策略（利用Spring加载）

其中第1、2点请参见`org.landy.strategy` 包下的demo事例即可，而第4点的方式其实就是结合第1、2、3点的优点进行整合的方式。

#### 2.3.2 注解方式优点

使用注解方式可以极大的减少使用模版方法模式带来的扩展时需要继承模版类的弊端，工厂+注解的方式可以无需关心其他业务类的实现，而且减少了类膨胀的风险。

#### 2.3.3 组合主键查询策略

本文以`组合主键查询策略`这一策略进行说明，策略注解如下：

```java
/**
 * 组合主键查询策略（根据不同业务流程区分组合主键查询策略,并且每个业务流程都有自己的优先级策略）
 * @author landyl
 * @create 2:22 PM 09/29/2018
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface KeyIdentificationStrategy {

    /**
     * 主键策略优先级
     * @return
     */
    int priority() default 0;
    /**
     * 业务流程类型(如：订单信息，会员信息等业务流程)
     * @return
     */
    WorkflowEnum workflowId();
    /**
     * the spring bean name
     * @return
     */
    String beanName();

}
```

#### 2.3.4 策略工厂

既然定义了组合主键查询策略注解，那必然需要一个**注解处理器**进行解析注解的操作，本文以工厂的方式进行。主要逻辑如下：

1. 扫描指定包下的Java类，找出相应接口（即`KeyIdentification`）下的所有Class对象。

   ```java
   private List<Class<? extends KeyIdentification>> getIdentifications() {
           Set<String> packageNames = this.getBasePackages();
           List<Class<? extends KeyIdentification>> identifications = new ArrayList<>();
           if(packageNames != null) {
               packageNames.forEach((packageName) -> identifications.addAll(getIdentifications(packageName)));
           }
           return identifications;
       }
   ```

2. 解析注解`KeyIdentificationStrategy`，定义一个排序对象（`KeyIdentificationComparator`），指定优先级。

   ```java
   private class KeyIdentificationComparator implements Comparator {
       @Override
       public int compare(Object objClass1, Object objClass2) {
           if(objClass1 != null && objClass2 != null) {
               Optional<KeyIdentificationStrategy> strategyOptional1 = getPrimaryKeyIdentificationStrategy((Class)objClass1);
               Optional<KeyIdentificationStrategy> strategyOptional2 = getPrimaryKeyIdentificationStrategy((Class)objClass2);
   
               KeyIdentificationStrategy ip1 = strategyOptional1.get();
               KeyIdentificationStrategy ip2 = strategyOptional2.get();
   
               Integer priority1 = ip1.priority();
               Integer priority2 = ip2.priority();
   
               WorkflowEnum workflow1 = ip1.workflowId();
               WorkflowEnum workflow2 = ip2.workflowId();
               //先按业务类型排序
               int result = workflow1.getValue() - workflow2.getValue();
               //再按优先级排序
               if(result == 0) return priority1.compareTo(priority2);
   
               return result;
           }
           return 0;
       }
   }
   ```

3. 根据注解，把相应业务类型的组合主键查询策略对象放入容器中（即`DefaultKeyIdentificationChain`）。

   ```java
   KeyIdentificationStrategy strategy = strategyOptional.get();
                   String beanName = strategy.beanName();
                   //业务流程类型
                   WorkflowEnum workflowId = strategy.workflowId();
                   KeyIdentificationStrategy priority = getPrimaryKeyIdentificationStrategy(v).get();
                   LOGGER.info("To add identification:{},spring bean name is:{},the identify priority is:{},workflowId:{}",simpleName,beanName,priority.priority(),workflowId.name());
                   KeyIdentification instance = ApplicationUtil.getApplicationContext().getBean(beanName,v);
   defaultKeyIdentificationChain.addIdentification(instance,workflowId);
   ```

4. 后续，在各自对应的业务查询组件对象中即可使用该工厂对象调用如下方法，即可进行相应的查询操作。

```java
public IdentificationResultType identify(IdentifyCriterion identifyCriterion,WorkflowEnum workflowId) {
        defaultKeyIdentificationChain.doClearIdentificationIndex(workflowId);
        return defaultKeyIdentificationChain.doIdentify(identifyCriterion,workflowId);
    }
```

## 3. 动态代理+Spring AOP

AOP设计模式通常运用在日志，校验等业务场景，本文将简单介绍基于Spring的AOP代理模式的运用。

### 3.1 Spring AOP

#### 3.1.1 Spring AOP原理

AOP实现的关键在于AOP框架自动创建的AOP代理，AOP代理主要分为静态代理和动态代理，**静态代理的代表为AspectJ；而动态代理则以Spring AOP为代表**。本文以Spring AOP的实现进行分析和介绍。

Spring AOP使用的动态代理，所谓的动态代理就是说AOP框架不会去修改字节码，而是在内存中临时为方法生成一个AOP对象，这个AOP对象包含了目标对象的全部方法，并且在特定的切点做了增强处理，并回调原对象的方法。

Spring AOP中的动态代理主要有两种方式，`JDK动态代理`和`CGLIB动态代理`。JDK动态代理通过反射来接收被代理的类，并且要求被代理的类必须实现一个接口。JDK动态代理的核心是`InvocationHandler`接口和`Proxy`类。

如果目标类没有实现接口，那么Spring AOP会选择使用CGLIB来动态代理目标类。CGLIB（Code Generation Library），是一个代码生成的类库，可以在运行时动态的生成某个类的子类，注意，CGLIB是通过继承的方式做的动态代理，因此如果某个类被标记为`final`，那么它是无法使用CGLIB做动态代理的。

> 注意：以上片段引用自文章[Spring AOP的实现原理](http://www.importnew.com/24305.html)，如有冒犯，请联系笔者删除之，谢谢！

Spring AOP判断是JDK代理还是CGLib代理的源码如下（来自`org.springframework.aop.framework.DefaultAopProxyFactory`）：

```java
@Override
public AopProxy createAopProxy(AdvisedSupport config) throws AopConfigException {
    if (config.isOptimize() || config.isProxyTargetClass() || hasNoUserSuppliedProxyInterfaces(config)) {
        Class<?> targetClass = config.getTargetClass();
        if (targetClass == null) {
            throw new AopConfigException("TargetSource cannot determine target class: " +
                                         "Either an interface or a target is required for proxy creation.");
        }
        if (targetClass.isInterface() || Proxy.isProxyClass(targetClass)) {
            return new JdkDynamicAopProxy(config);
        }
        return new ObjenesisCglibAopProxy(config);
    }
    else {
        return new JdkDynamicAopProxy(config);
    }
}
```

由代码发现，如果配置`proxyTargetClass = true`了并且目标类非接口的情况，则会使用CGLib代理，否则使用JDK代理。

#### 3.1.2 Spring AOP配置

Spring AOP的配置有两种方式，XML和注解方式。

##### 3.1.2.1 XML配置

首先需要引入AOP相关的DTD配置，如下：

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
	   xmlns:aop="http://www.springframework.org/schema/aop"
	   xsi:schemaLocation="
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
		http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.2.xsd
		">
```

然后需要引入AOP自动代理配置：

```xml
<!-- 自动扫描(自动注入) -->
<context:component-scan base-package="org.landy" />
<!-- 指定proxy-target-class为true可强制使用cglib -->
<aop:aspectj-autoproxy proxy-target-class="true"></aop:aspectj-autoproxy>
```

##### 3.1.2.2 注解配置

Java配置类如下：

```java
/**
 * 相当于Spring.xml配置文件的作用
 * @author landyl
 * @create 2:44 PM 09/30/2018
 */
@Configuration
//@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
@EnableAspectJAutoProxy(proxyTargetClass = true)
//@EnableAspectJAutoProxy
@ComponentScan(basePackages = "org.landy")
public class ApplicationConfigure {

    @Bean
    public ApplicationUtil getApplicationUtil() {
        return new ApplicationUtil();
    }

}
```

##### 3.1.2.3 依赖包

需要使用Spring AOP需要引入以下Jar包：

```xml
<properties>
    <spring.version>5.0.8.RELEASE</spring.version>
    <aspectj.version>1.8.7</aspectj.version>
</properties>
<!-- aspectjrt.jar包主要是提供运行时的一些注解，静态方法等等东西，通常我们要使用aspectJ的时候都要使用这个包。 -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjrt</artifactId>
    <version>${aspectj.version}</version>
</dependency>
<!-- aspectjweaverjar包主要是提供了一个java agent用于在类加载期间织入切面(Load time weaving)。
    并且提供了对切面语法的相关处理等基础方法，供ajc使用或者供第三方开发使用。这个包一般我们不需要显式引用，除非需要使用LTW。
     -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>${aspectj.version}</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aop</artifactId>
    <version>${spring.version}</version>
    <scope>compile</scope>
</dependency>
```



##### 3.1.2.4 配置单元测试

以上两种配置方式，单元测试需要注意一个地方就是引入配置的方式不一样，区别如下：

1. XML方式

   ```java
   @ContextConfiguration(locations = { "classpath:spring.xml" }) //加载配置文件
   @RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
   public class SpringTestBase extends AbstractJUnit4SpringContextTests {
   }
   ```

2. 注解方式

```java
@ContextConfiguration(classes = ApplicationConfigure.class)
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
public class SpringTestBase extends AbstractJUnit4SpringContextTests {
}
```

配置好了以后，以后所有的测试类都继承`SpringTestBase`类即可。

### 3.2 项目演示

#### 3.2.1 逻辑梳理

本文将以校验某个业务逻辑为例说明Spring AOP代理模式的运用。

按照惯例，还是以客户信息更新校验为例，假设有个校验类如下：

```java
/**
 * @author landyl
 * @create 2:22 PM 09/30/2018
 */
@Component
public class CustomerUpdateRule implements UpdateRule {

    //利用自定义注解，进行AOP切面编程，进行其他业务逻辑的校验操作
    @StatusCheck
    public CheckResult check(String updateStatus, String currentStatus) {
        System.out.println("CustomerUpdateRule:在此还有其他业务校验逻辑。。。。"+updateStatus + "____" + currentStatus);
        return new CheckResult();
    }

}
```

此时我们需要定义一个注解`StatusCheck`类，如下：

```java
/**
 * @author landyl
 * @create 2:37 PM 09/23/2018
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StatusCheck {

}
```

此注解仅为一个标记注解。最为主要的就是定义一个更新校验的切面类，定义好切入点。

```java
@Component
@Aspect
public class StatusCheckAspect {
    private static final int VALID_UPDATE = Constants.UPDATE_STATUS_VALID_UPDATE;

    private static final Logger LOGGER = LoggerFactory.getLogger(StatusCheckAspect.class);


    //定义切入点:定义一个方法，用于声明切面表达式，一般地，该方法中不再需要添加其他的代码
    @Pointcut("execution(* org.landy.business.rules..*(..)) && @annotation(org.landy.business.rules.annotation.StatusCheck)")
    public void declareJoinPointExpression() {}

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before("declareJoinPointExpression()")
    public void beforeCheck(JoinPoint joinPoint) {
        System.out.println("before statusCheck method start ...");
        System.out.println(joinPoint.getSignature());
        //获得自定义注解的参数
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " begins with " + args);
        System.out.println("before statusCheck method end ...");
    }
}    
```

具体代码请参见[github](https://github.com/landy8530/DesignPatterns)。

#### 3.2.2 逻辑测试

##### 3.2.2.1 JDK动态代理

JDK动态代理必须实现一个接口，本文实现`UpdateRule`为例，

```java
public interface UpdateRule {
    CheckResult check(String updateStatus, String currentStatus);
}
```

并且AOP需要做如下配置：

XML方式：

```xml
<!-- 指定proxy-target-class为true可强制使用cglib -->
<aop:aspectj-autoproxy proxy-target-class="false"></aop:aspectj-autoproxy>
```

注解方式：

```java
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "org.landy")
public class ApplicationConfigure {

}
```

在测试类中，必须使用接口方式注入：

```java
/**
 * @author landyl
 * @create 2:32 PM 09/30/2018
 */
public class CustomerUpdateRuleTest extends SpringTestBase {

    @Autowired
    private UpdateRule customerUpdateRule; //JDK代理方式必须以接口方式注入

    @Test
    public void customerCheckTest() {
        System.out.println("proxy class:" + customerUpdateRule.getClass());
        CheckResult checkResult = customerUpdateRule.check("2","currentStatus");
        AssertUtil.assertTrue(checkResult.getCheckResult() == 0,"与预期结果不一致");
    }

}
```

测试结果如下：

```
proxy class:class com.sun.proxy.$Proxy34
2018-10-05  14:18:17.515 [main] INFO  org.landy.business.rules.aop.StatusCheckAspect - Status check around method start ....
before statusCheck method start ...
CheckResult org.landy.business.rules.stategy.UpdateRule.check(String,String)
The method check begins with [2, currentStatus]
before statusCheck method end ...
CustomerUpdateRule:在此还有其他业务校验逻辑。。。。2____currentStatus
2018-10-05  14:18:17.526 [main] INFO  org.landy.business.rules.aop.StatusCheckAspect - execute the target method,the return result_msg:null
2018-10-05  14:18:17.526 [main] INFO  org.landy.business.rules.aop.StatusCheckAspect - Status check around method end ....
```

以上结果说明它生成的代理类为$Proxy34，说明是JDK代理。

##### 3.2.2.2 CGLib动态代理

使用CGlib可以不用接口（经测试，用了接口好像也没问题）。在测试类中，必须使用实现类方式注入：

```java
 @Autowired
 private CustomerUpdateRule customerUpdateRule;
```

并且AOP需要做如下配置：

XML方式：

```xml
<!-- 指定proxy-target-class为true可强制使用cglib -->
<aop:aspectj-autoproxy proxy-target-class="true"></aop:aspectj-autoproxy>
```

注解方式：

```java
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = "org.landy")
public class ApplicationConfigure {

}
```

不过发现我并未配置`proxyTargetClass = true`也可以正常运行，有点奇怪。（按理说，默认是为false）

运行结果生成的代理类为：

```
proxy class:class org.landy.business.rules.stategy.CustomerUpdateRule$$EnhancerBySpringCGLIB$$d1075aca
```

说明是CGLib代理。

经过进一步测试，发现如果我实现接口`UpdateRule`，但是注入方式使用类注入方式：

```java
@Autowired
private CustomerUpdateRule customerUpdateRule;
```

并且把`proxyTargetClass`设置为false，则运行就报如下错误：

```
严重: Caught exception while allowing TestExecutionListener [org.springframework.test.context.support.DependencyInjectionTestExecutionListener@6a024a67] to prepare test instance [org.landy.business.rules.CustomerUpdateRuleTest@7fcf2fc1]
org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'org.landy.business.rules.CustomerUpdateRuleTest': Unsatisfied dependency expressed through field 'customerUpdateRule'; nested exception is org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'customerUpdateRule' is expected to be of type 'org.landy.business.rules.stategy.CustomerUpdateRule' but was actually of type 'com.sun.proxy.$Proxy34'
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:586)
```

以上说明了一个问题，使用接口实现的方式则会被默认为JDK代理方式，如果需要使用CGLib代理，需要把`proxyTargetClass`设置为`true`。

##### 3.2.2.3 综合测试

为了再次验证Spring AOP如何选择JDK代理还是CGLib代理，在此进行一个综合测试。

测试前提：

1. 实现`UpdateRule`接口

2. 测试类使用接口方式注入

   ```java
   @Autowired
   private UpdateRule customerUpdateRule; //JDK代理方式必须以接口方式注入
   ```

测试：

配置`proxyTargetClass`为`true`，运行结果如下：

```
customerCheckTest
proxy class:class org.landy.business.rules.stategy.CustomerUpdateRule$$EnhancerBySpringCGLIB$$f5a34953
2018-10-05  15:28:42.820 [main] INFO  org.landy.business.rules.aop.StatusCheckAspect - Status check around method start ....
2018-10-05  15:28:42.823 [main] INFO  org.landy.business.rules.aop.StatusCheckAspect - Status check dynamic AOP,paramValues:2
AOP实际校验逻辑。。。。2----currentStatus
before statusCheck method start ...
target class:org.landy.business.rules.stategy.CustomerUpdateRule@7164ca4c
```

说明为CGLIb代理。

配置`proxyTargetClass`为`false`，运行结果如下：

```
proxy class:class com.sun.proxy.$Proxy34
2018-10-05  15:20:59.894 [main] INFO  org.landy.business.rules.aop.StatusCheckAspect - Status check around method start ....
before statusCheck method start ...
target class:org.landy.business.rules.stategy.CustomerUpdateRule@ae3540e
```

说明为JDK代理。

以上测试说明，指定proxy-target-class为true可强制使用cglib。

#### 3.2.3 常见问题

如果使用JDK动态代理，未使用接口方式注入（或者使用接口实现，并未配置`proxyTargetClass`为true），则会出现以下异常信息：

```
严重: Caught exception while allowing TestExecutionListener [org.springframework.test.context.support.DependencyInjectionTestExecutionListener@6a024a67] to prepare test instance [org.landy.business.rules.CustomerUpdateRuleTest@7fcf2fc1]
org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'org.landy.business.rules.CustomerUpdateRuleTest': Unsatisfied dependency expressed through field 'customerUpdateRule'; nested exception is org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'customerUpdateRule' is expected to be of type 'org.landy.business.rules.stategy.CustomerUpdateRule' but was actually of type 'com.sun.proxy.$Proxy34'
```

与生成的代理类型不一致，有兴趣的同学可以Debug `DefaultAopProxyFactory`类中的`createAopProxy`方法即可自动两种动态代理的区别。