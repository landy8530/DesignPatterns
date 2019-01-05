package org.landy.visitor;

/**
 * 登录接口
 * Created by Landy on 2019/1/5.
 */
public interface Login {

    //对于登录而言，访问者是被接受的,我根本不知道访问者是谁
    void accept(Visitor visitor);

}
