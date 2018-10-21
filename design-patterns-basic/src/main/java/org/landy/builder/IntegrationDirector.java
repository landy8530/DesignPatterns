package org.landy.builder;

/**
 * @author landyl
 * @create 10:32 AM 03/29/2018
 */
public class IntegrationDirector {

    public IntegrationData buildIntegrationData(IntegrationBuilder builder) {
        System.out.println("开始集成数据到业务系统....");
        //用户信息
        builder.buildUserProfile();

        //订单计划
        builder.buildSelectedPlans();

        //订单
        builder.buildOrder();

        //订单成员
        builder.buildMember() ;

        IntegrationData data = builder.buildIntegrationData();
        return data;
    }
}
