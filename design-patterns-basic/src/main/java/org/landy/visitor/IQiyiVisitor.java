package org.landy.visitor;

/**
 * Created by Landy on 2019/1/5.
 */
public class IQiyiVisitor implements Visitor {
    @Override
    public void visit(Login login) {
        System.out.println("爱奇艺访问者");
        login.accept(this);
    }

//    @Override
//    public void visitYouku(Login login) {
//        System.out.println("爱奇艺访问者");
//        login.accept(this);
//    }
}
