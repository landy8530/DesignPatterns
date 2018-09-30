package org.landy.business.identify.component.enums;

/**
 * 组合主键查询策略优先级常量类
 * 区分了不同的业务流程类型
 * @author landyl
 * @create 11:13 AM 09/05/2018
 */
public class PrimaryKeyCombination {
    public static final int PRIORITY_ZERO = 0;
    public static final int PRIORITY_ONE = 1;
    public static final int PRIORITY_TWO = 2;
    public static final int PRIORITY_THREE = 3;
    public static final int PRIORITY_FOUR = 4;


    public enum Policy {
        POLICY_ID(PRIORITY_ZERO),
        APP_ID_MEDICARE(PRIORITY_ONE),
        APP_ID_MEMBER_NUMBER(PRIORITY_TWO),
        APP_ID_FIRST_NAME_BIRTH_DATE_EFF_DATE(PRIORITY_THREE),
        MEDICARE_ID_FIRST_NAME_BIRTH_DATE_EFF_DATE(PRIORITY_FOUR),

        ;

        public int priority;

        Policy(int priority) {
            this.priority = priority;
        }
    }

    public enum Application {
        APPLICATION_ID(PRIORITY_ZERO),

        ;

        public int priority;

        Application(int priority) {
            this.priority = priority;
        }
    }

}
