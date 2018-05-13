package org.landy.business.domain.file;

import org.apache.commons.lang.StringUtils;
import org.landy.business.domain.detail.PolicyRequestDetail;
import org.landy.business.enums.WorkflowEnum;
import org.landy.constants.Constants;
import org.landy.utils.BeanUtil;
import org.landy.utils.CamelCaseUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author landyl
 * @create 9:46 AM 05/08/2018
 */
public class PolicyRequestFile extends RequestFile<PolicyRequestDetail> {

    public static final String[] policyDetailHeaders = {
            "ROW_NUMBER", "PARENT_CARRIER_ID", "APPLICATION_ID", "MEMBER_NUMBER",
            "POLICY_ID", "PRODUCT_LINE", "PLAN_NAME", "CATEGORY_CLASS_ID",
            "BIRTH_DATE", "FULL_NAME", "FIRST_NAME", "MIDDLE_NAME",
            "LAST_NAME", "EFFECTIVE_START_DATE", "CANCELLATION_DATE", "REVENUE_IMPACT_DATE",
            "CARRIER_EFFECTIVE_DATE", "CARRIER_ID", "PLAN_ID", "RIDER_ID",
            "POLICY_NUMBER", "FREQUENCY_TO_DEBIT", "MONTHLY_PREMIUM", "RATE_TIER",
            "NOT_CANCELLED", "IS_DELINQUENT", "DELINQUENCY_NOTE", "MEMBER_COUNT",
            "STATUS_CODE", "STATUS_DATE", "IS_ACTIVE", "IS_REVERSED",
            "IS_MASTER_POLICY", "CATEGORY", "SUBSCRIBER_COUNT", "EMAIL",
            "ADDRESS_TYPE", "ADDRESS_LINE_1", "ADDRESS_LINE_2", "ADDRESS_LINE_3",
            "CITY", "STATE", "ZIP_CODE", "COUNTY", "BUSINESS_LINE", "GROUP_NAME"
    };

    private List<PolicyRequestDetail> requestPolicyDetails;

    private List<PolicyRequestDetail> getRequestPolicyDetails() {
        if (requestPolicyDetails == null) {
            List<String> detailLines = getDetailLines();
            if (detailLines == null) return null;
            PolicyRequestDetail detail;
            requestPolicyDetails = new ArrayList<>();
            for (String detailLine : detailLines) {
                detail = parseDetailLinesToRequestPolicyDetail(detailLine);
                setSmbValuesWhenIsSmb(detail);
                requestPolicyDetails.add(detail);
            }
        }

        return requestPolicyDetails;
    }

    private void setSmbValuesWhenIsSmb(PolicyRequestDetail detail) {
        if(detail.getBusinessLine() != null && "1".equals(detail.getBusinessLine().trim())){
            if(detail.getPolicyId() != null && !detail.getPolicyId().isEmpty()){
                detail.setPolicyId("-" + detail.getPolicyId());
            }

            if(detail.getCarrierId() != null && !detail.getCarrierId().isEmpty()){
                detail.setCarrierId("-" + detail.getCarrierId());
            }

            if(detail.getPlanId() != null && !detail.getPlanId().isEmpty()){
                detail.setPlanId("-" + detail.getPlanId());
            }

            if(detail.getRiderId() != null && !detail.getRiderId().isEmpty()){
                detail.setRiderId("-" + detail.getRiderId());
            }

            if(detail.getApplicationId() != null && !detail.getApplicationId().isEmpty()){
                detail.setApplicationId("-" + detail.getApplicationId());
            }

            setRafForSMBAccordingSourceData(detail);
        }
    }

    private void setRafForSMBAccordingSourceData(PolicyRequestDetail detail) {
        detail.setRaf(detail.getRateTier());
        detail.setRateTier(null);
    }

    private PolicyRequestDetail parseDetailLinesToRequestPolicyDetail(String detailLine) {
        PolicyRequestDetail detail = new PolicyRequestDetail();

        String propertyName;
        String propertyValue;
        String[] detailValues;
        detailValues = detailLine.split(Constants.DELIMITER_PIPE);
        for (int i = 0; i < detailValues.length; i++) {
            propertyValue = detailValues[i];

            if (StringUtils.isEmpty(propertyValue)) continue;

            propertyName = CamelCaseUtil.toCamelCase(policyDetailHeaders[i]);
            BeanUtil.setProperty(detail, propertyName, propertyValue);
        }
        return detail;
    }

    @Override
    public List<PolicyRequestDetail> getRequestDetails() {
        return getRequestPolicyDetails();
    }

    @Override
    public String[] getDetailHeaders() {
        return policyDetailHeaders;
    }

    @Override
    public int getProcessWorkFlow() {
        processWorkFlow = WorkflowEnum.POLICY.getValue();
        return processWorkFlow;
    }
}
