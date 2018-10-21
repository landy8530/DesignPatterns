package org.landy.builder;

import org.landy.builder.domain.Member;
import org.landy.builder.domain.Order;
import org.landy.builder.domain.SelectedPlans;
import org.landy.builder.domain.UserProfile;

/**
 * @author landyl
 * @create 10:16 AM 03/29/2018
 */
public interface IntegrationBuilder {

    UserProfile buildUserProfile() ;

    SelectedPlans buildSelectedPlans();

    Order buildOrder();

    Member buildMember() ;

    IntegrationData buildIntegrationData();

}
