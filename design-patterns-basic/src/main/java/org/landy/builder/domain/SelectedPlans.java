package org.landy.builder.domain;

/**
 * @author landyl
 * @create 5:04 PM 05/12/2018
 */
public class SelectedPlans {

    private String planId;
    private String planName;

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    @Override
    public String toString() {
        return " 计划信息：" + planId + "---" + planName;
    }
}
