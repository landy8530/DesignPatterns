package org.landy.strategy.demo2;

import org.landy.strategy.demo2.calc.*;

/**
 *
 * 假设鹅厂推出了3种会员，分别为会员，超级会员以及金牌会员，还有就是普通玩家，针对不同类别的玩家，购买《王者农药》皮肤有不同的打折方式，
 * 并且一个顾客每消费10000就增加一个级别，那么我们就可以使用策略模式，因为策略模式描述的就是算法的不同，这里我们举例就采用最简单的，
 * 以上四种玩家分别采用原价（普通玩家），九折，八折和七价的收钱方式。
 *
 * @author landyl
 * @create 2:46 PM 05/12/2018
 */
public class Player {

    private Double totalAmount = 0D;//客户在鹅厂消费的总额
    private Double amount = 0D;//客户单次消费金额
    private CalPrice calPrice = new Origin();//每个客户都有一个计算价格的策略，初始都是普通计算，即原价

    //客户购买皮肤，就会增加它的总额
    public void buy(Double amount) {
        this.amount = amount;
        totalAmount += amount;
        //实现方式一：不使用工厂，直接客户类判断策略
//        if (totalAmount > 30000) {//30000则改为金牌会员计算方式
//            calPrice = new GoldVip();
//        } else if (totalAmount > 20000) {//类似
//            calPrice = new SuperVip();
//        } else if (totalAmount > 10000) {//类似
//            calPrice = new Vip();
//        }

        //实现方式二：我们将策略的制定转移给了策略工厂，将这部分责任分离出去
//        calPrice = CalPriceFactory.createCalPrice(this);

        //实现方式三：利用注解动态配置策略
//        虽然结合简单工厂模式，我们的策略模式灵活了一些，
//        但不免发现在工厂中多了if-else判断，也就是如果增加一个会员类别，我又得增加一个else-if语句，这是简单工厂的缺点，对修改开放。
//        那有什么方法，可以较好的解决这个问题呢？那就是使用注解，
//        所以我们需要给注解加入属性上限和下限，用来表示策略生效的区间，用来解决总金额判断的问题。

        calPrice = CalPriceFactory.getInstance().createCalPrice(this);

    }

    //计算客户最终要付的钱
    public Double calLastAmount() {
        return calPrice.calPrice(amount);
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
