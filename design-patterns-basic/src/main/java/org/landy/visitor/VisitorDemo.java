package org.landy.visitor;

/**
 * Created by Landy on 2019/1/6.
 */
public class VisitorDemo {

    public static void main(String[] args) {
        //优酷访问者
        Visitor visitor = new YoukuVisitor();
        //微博登录
//        Login login = new WeiboLogin();
        Login login = new WechatLogin();
        //优酷访问者 -> 微博登录
        visitor.visit(login);

        ////////////////
        login = new QQLogin();
        visitor = new IQiyiVisitor();
        visitor.visit(login);


    }

}
