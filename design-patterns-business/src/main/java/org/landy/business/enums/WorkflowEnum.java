package org.landy.business.enums;

/**
 * 业务流程枚举
 * @author landyl
 * @create 11:18 AM 05/07/2018
 */
public enum WorkflowEnum {
    UNKNOWN(0),
    POLICY(1),
    ORDER(2),
    CUSTOMER(3),
    APPLICATION(4),
    XHF(5),

    ;

    private int value;

    WorkflowEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static WorkflowEnum fromValue(int value) {
        for (WorkflowEnum option : values()) {
            if (option.getValue() == value) {
                return option;
            }
        }
        return UNKNOWN;
    }

}
