package org.landy.builder;

import org.landy.builder.domain.Member;
import org.landy.builder.domain.Order;
import org.landy.builder.domain.SelectedPlans;
import org.landy.builder.domain.UserProfile;

/**
 * @author landyl
 * @create 10:21 AM 03/29/2018
 */
public class IntegrationData {

    private UserProfile userProfile;
    private SelectedPlans selectedPlans;
    private Order order;
    private Member member;

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public SelectedPlans getSelectedPlans() {
        return selectedPlans;
    }

    public void setSelectedPlans(SelectedPlans selectedPlans) {
        this.selectedPlans = selectedPlans;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return userProfile.toString() + "\n" + selectedPlans.toString() + "\n"
                + order.toString() + "\n" + member.toString();
    }
}
