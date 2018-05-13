package org.landy.business.domain.file;

import org.apache.commons.lang.StringUtils;
import org.landy.business.domain.detail.BOBRequestDetail;
import org.landy.business.enums.WorkflowEnum;
import org.landy.constants.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @author landyl
 * @create 9:46 AM 05/08/2018
 */
public class BOBRequestFile extends RequestFile<BOBRequestDetail> {
    public static final String[] bobDetailHeaders = {
            "ROW_NUMBER", "SYSTEM_SOURCE", "SYSTEM_SOURCE_ID","MEMBER_NUMBER",
            "IS_POLICY", "STATUS_CODE", "STATUS_DATE", "CARRIER_INTEGRATE_FLOW_ID", "INTEGRATE_PLAN",
            "CARRIER_NAME", "CARRIER_STATE", "CARRIER_PRODUCT_LINE", "PLAN_NAME", "CARRIER_ID",
            "PLAN_ID", "RIDER_ID", "FIRST_NAME", "MIDDLE_NAME", "LAST_NAME", "GENDER", "BIRTH_DATE",
            "POLICY_NUMBER", "MONTHLY_PREMIUM", "FREQUENCY_TO_DEBIT", "CARRIER_EFFECTIVE_DATE",
            "EFFECTIVE_START_DATE", "CANCELLATION_DATE", "ADDRESS_TYPE", "ADDRESS_LINE_1", "ADDRESS_LINE_2",
            "CITY", "STATE", "ZIP_CODE", "EMAIL", "DAY_PHONE_NUMBER", "EVENING_PHONE_NUMBER", "MOBILE_PHONE_NUMBER",
            "FAX_PHONE_NUMBER", "SALES_REP", "MEDICARE_ID", "ALLIANCE_ID", "ALLIANCE_UID", "ALLIANCE_PARTNER_ID", "LEAD_ID", "SOURCE_PARTNER_ID", "USER_PROFILE_ID"
    };

    private List<BOBRequestDetail> requestBOBDetails;

    //FSIS-2993
    private void setNonGMGValues(BOBRequestDetail detail) {
        String systemSourceId = detail.getSystemSourceId();
        String systemSource = detail.getSystemSource();
        //When the CARRIER_INTEGRATE_FLOW_ID=0 is leveraged, the following is true:
        //INTEGRATE_PLAN should be NULL
        if(!(StringUtils.isNotEmpty(systemSource) && StringUtils.isNotEmpty(systemSourceId)) || "0".equals(detail.getCarrierIntegrateFlowId())) {
            detail.setIntegratePlan(null);
        }
    }

    private List<BOBRequestDetail> getRequestBOBDetails() {
        if (requestBOBDetails == null) {
            List<String> detailLines = getDetailLines();

            if (detailLines == null) return null;

            BOBRequestDetail detail;
            requestBOBDetails = new ArrayList<>();
            for (String detailLine : detailLines) {
                detail = parseDetailLinesToRequestBOBDetail(detailLine);

                setNonGMGValues(detail); //FSIS-2993
                //2018.04.28 address type must be upper case
                if(StringUtils.isNotEmpty(detail.getAddressType())) {
                    detail.setAddressType(detail.getAddressType().toUpperCase());
                }

                requestBOBDetails.add(detail);
            }
        }

        return requestBOBDetails;
    }

    private BOBRequestDetail parseDetailLinesToRequestBOBDetail(String detailLine) {
        BOBRequestDetail detail = new BOBRequestDetail();
        String[] detailValues = detailLine.split(Constants.DELIMITER_PIPE);
        parseToDetail(detail,detailValues);
        return detail;
    }

    @Override
    public List<BOBRequestDetail> getRequestDetails() {
        return getRequestBOBDetails();
    }

    @Override
    public String[] getDetailHeaders() {
        return bobDetailHeaders;
    }

    @Override
    public WorkflowEnum getProcessWorkFlow() {
        return WorkflowEnum.BOB;
    }

}
