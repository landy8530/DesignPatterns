package org.landy.decorator.demo2;

/**
 * 抽象成绩单
 * @author landyl
 * @create 4:44 PM 07/16/2018
 */
public interface SchoolReport {
    /**
     * 报告成绩
     */
    void report();

    /**
     * 签名
     * @param name
     */
    void sign(String name);

}
