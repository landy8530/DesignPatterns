package org.landy.business.domain.file;

import org.landy.business.domain.detail.PolicyRequestDetail;
import org.landy.business.enums.WorkflowEnum;
import org.landy.constants.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @author landyl
 * @create 9:46 AM 05/08/2018
 */
public class PolicyRequestFile extends RequestFile<PolicyRequestDetail> {

    public static final String[] policyDetailHeaders = {
            "ROW_NUMBER", "SYSTEM_SOURCE", "SYSTEM_SOURCE_ID", "MEMBER_NUMBER",
            "IS_ACTIVE", "IS_REVERSED","NOT_CANCELLED","GENDER","BUSINESS_LINE","MEMBER_COUNT"
    };

    private List<PolicyRequestDetail> requestPolicyDetails;

    @Override
    public List<PolicyRequestDetail> getRequestDetails() {
        return getRequestPolicyDetails();
    }

    @Override
    public String[] getDetailHeaders() {
        return policyDetailHeaders;
    }

    @Override
    public WorkflowEnum getProcessWorkFlow() {
        return WorkflowEnum.POLICY;
    }

    private List<PolicyRequestDetail> getRequestPolicyDetails() {
        if (requestPolicyDetails == null) {
            List<String> detailLines = getDetailLines();
            if (detailLines == null) return null;
            PolicyRequestDetail detail;
            requestPolicyDetails = new ArrayList<>();
            for (String detailLine : detailLines) {
                detail = parseDetailLinesToRequestPolicyDetail(detailLine);
                requestPolicyDetails.add(detail);
            }
        }

        return requestPolicyDetails;
    }

    private PolicyRequestDetail parseDetailLinesToRequestPolicyDetail(String detailLine) {
        PolicyRequestDetail detail = new PolicyRequestDetail();
        String[] detailValues = detailLine.split(Constants.DELIMITER_PIPE);
        parseToDetail(detail,detailValues);
        return detail;
    }

}
