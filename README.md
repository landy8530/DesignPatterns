# 写在前面

## 主要内容

为了更系统的学习设计模式，特地开了这样一个基于Java的设计模式【集中营】，都是笔者在实际工作中用到过或者学习过的一些设计模式的一些提炼或者总检。慢慢地初见规模，也有几个朋友给我点鼓励，给了star。本文工程主要计划以下几大块，希望大家也可以一起加入进来，扩大Java设计模式这块的运用场景的提炼。

1. 设计模式简介：主要介绍各种设计模式的概念和运用场景等
2. 设计模式综合运用：主要是笔者在实际工作中运用到的一些设计模式综合运用事例的提炼
3. Spring设计模式简介：主要是讲述Spring源码中运用到的一些设计模式（将来增加）
4. Ibatis设计模式简介：主要是讲述Ibatis源码中运用到的一些设计模式（将来增加）

## 分享说明

本文所有文档和代码为笔者亲测可用，部分来源于网络（主要是【设计模式简介】模块，如有侵权，请联系笔者），如果大家有任何问题，都可以提交issue，或者提交PR等。

# 设计模式简介

* 1 [单例模式](https://github.com/landy8530/DesignPatterns/wiki/1.-%E5%8D%95%E4%BE%8B%E6%A8%A1%E5%BC%8F)
* 2 [责任链模式](https://github.com/landy8530/DesignPatterns/wiki/2.-%E8%B4%A3%E4%BB%BB%E9%93%BE%E6%A8%A1%E5%BC%8F)
* 3 [策略模式](https://github.com/landy8530/DesignPatterns/wiki/3.-%E7%AD%96%E7%95%A5%E6%A8%A1%E5%BC%8F)
* 4 [模板方法模式](https://github.com/landy8530/DesignPatterns/wiki/4.-%E6%A8%A1%E6%9D%BF%E6%96%B9%E6%B3%95%E6%A8%A1%E5%BC%8F)
* 5 [工厂方法模式](https://github.com/landy8530/DesignPatterns/wiki/5.-%E5%B7%A5%E5%8E%82%E6%96%B9%E6%B3%95%E6%A8%A1%E5%BC%8F)
* 6 [抽象工厂模式](https://github.com/landy8530/DesignPatterns/wiki/6.-%E6%8A%BD%E8%B1%A1%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F)
* 7 [建造者模式](https://github.com/landy8530/DesignPatterns/wiki/7.-%E5%BB%BA%E9%80%A0%E8%80%85%E6%A8%A1%E5%BC%8F)
* 8 [代理模式](https://github.com/landy8530/DesignPatterns/wiki/8.-%E4%BB%A3%E7%90%86%E6%A8%A1%E5%BC%8F)
* 9 [装饰模式](https://github.com/landy8530/DesignPatterns/wiki/9.-%E8%A3%85%E9%A5%B0%E6%A8%A1%E5%BC%8F)
* 10 [原型模式](https://github.com/landy8530/DesignPatterns/wiki/10.-%E5%8E%9F%E5%9E%8B%E6%A8%A1%E5%BC%8F)
* 11 [委派模式](https://github.com/landy8530/DesignPatterns/wiki/11.-%E5%A7%94%E6%B4%BE%E6%A8%A1%E5%BC%8F)

# 设计模式综合运用

* [1 门面+模版方法+责任链+策略](https://github.com/landy8530/DesignPatterns/wiki/1.-%E9%97%A8%E9%9D%A2-%E6%A8%A1%E7%89%88%E6%96%B9%E6%B3%95-%E8%B4%A3%E4%BB%BB%E9%93%BE-%E7%AD%96%E7%95%A5)
* [2 门面+模版方法+责任链+策略+工厂方法](https://github.com/landy8530/DesignPatterns/wiki/2.-%E9%97%A8%E9%9D%A2-%E6%A8%A1%E7%89%88%E6%96%B9%E6%B3%95-%E8%B4%A3%E4%BB%BB%E9%93%BE-%E7%AD%96%E7%95%A5-%E5%B7%A5%E5%8E%82%E6%96%B9%E6%B3%95)
* [3 动态代理+Spring AOP](https://github.com/landy8530/DesignPatterns/wiki/3.-%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86-Spring-AOP)