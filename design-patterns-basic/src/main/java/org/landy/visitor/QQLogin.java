package org.landy.visitor;

/**
 * Created by Landy on 2019/1/6.
 */
public class QQLogin implements Login {
    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getSimpleName() + "-QQ登录");
    }
}
