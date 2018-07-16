package org.landy.business.enums;

/**
 * @author landyl
 * @create 11:18 AM 05/07/2018
 */
public enum WorkflowEnum {
    UNKNOWN(0),
    POLICY(1),
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

    public static boolean isBOB(int value) {
        return XHF.value == value;
    }

    public static boolean isPolicy(int value) {
        return POLICY.value == value;
    }
}
