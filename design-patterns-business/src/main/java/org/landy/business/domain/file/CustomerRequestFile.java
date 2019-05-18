package org.landy.business.domain.file;

import org.landy.business.domain.detail.CustomerRequestDetail;
import org.landy.business.enums.WorkflowEnum;
import org.landy.constants.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @author landyl
 * @create 9:46 AM 05/08/2018
 */
public class CustomerRequestFile extends RequestFile<CustomerRequestDetail> {

    public static final String[] policyDetailHeaders = {
            "ROW_NUMBER", "MEMBER_NUMBER",
            "IS_ACTIVE", "IS_REVERSED","NOT_CANCELLED","GENDER","BUSINESS_LINE","MEMBER_COUNT"
    };

    private List<CustomerRequestDetail> requestPolicyDetails;

    @Override
    public List<CustomerRequestDetail> getRequestDetails() {
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

    private List<CustomerRequestDetail> getRequestPolicyDetails() {
        if (requestPolicyDetails == null) {
            List<String> detailLines = getDetailLines();
            if (detailLines == null) return null;
            CustomerRequestDetail detail;
            requestPolicyDetails = new ArrayList<>();
            for (String detailLine : detailLines) {
                detail = parseDetailLinesToRequestPolicyDetail(detailLine);
                requestPolicyDetails.add(detail);
            }
        }

        return requestPolicyDetails;
    }

    private CustomerRequestDetail parseDetailLinesToRequestPolicyDetail(String detailLine) {
        CustomerRequestDetail detail = new CustomerRequestDetail();
        String[] detailValues = detailLine.split(Constants.DELIMITER_PIPE);
        parseToDetail(detail,detailValues);
        return detail;
    }

}
