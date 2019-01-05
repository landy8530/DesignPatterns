package org.landy.visitor;

/**
 * Created by Landy on 2019/1/5.
 */
public class WechatLogin implements Login {
    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getSimpleName() + "-微信登录");
    }
}
