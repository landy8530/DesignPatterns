package org.landy.decorator.demo2;

/**
 * 修饰的抽象类
 * @author landyl
 * @create 4:47 PM 07/16/2018
 */
public abstract class Decorator implements SchoolReport {
    private SchoolReport sr;
    public Decorator(SchoolReport sr){
        this.sr = sr;
    }
    // 报告成绩
    @Override
    public void report() {
        this.sr.report();
    }
    // 家长签名
    @Override
    public void sign(String name) {
        this.sr.sign(name);
    }

}
