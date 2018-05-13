package org.landy.business.enums;

/**
 * @author landyl
 * @create 11:18 AM 05/07/2018
 */
public enum WorkflowEnum {
    UNKNOWN(0),
    POLICY(1),
    BOB(5),

    ;

    private int value;

    WorkflowEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isBOB(int value) {
        return BOB.value == value;
    }

    public static boolean isPolicy(int value) {
        return POLICY.value == value;
    }
}
