package org.landy.visitor;

/**
 * Created by Landy on 2019/1/5.
 */
public class WeiboLogin implements Login {
    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getSimpleName() + "-微博登录");
    }
}
