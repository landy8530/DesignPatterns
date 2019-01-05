package org.landy.visitor;

/**
 * 访问者接口
 * Created by Landy on 2019/1/5.
 */
public interface Visitor {

    //对于访问者而言，登录是访问者的对象，我不关心是怎么登录的
    void visit(Login login);

}
