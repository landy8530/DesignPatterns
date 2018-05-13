package org.landy.business.validation.detail.policy;

import org.apache.commons.lang.StringUtils;
import org.landy.business.domain.detail.PolicyRequestDetail;
import org.landy.business.domain.file.PolicyRequestFile;
import org.landy.business.validation.Validator;
import org.landy.business.validation.ValidatorChain;
import org.landy.business.validation.ValidatorConstants;
import org.landy.constants.Constants;
import org.landy.exception.BusinessValidationException;
import org.springframework.stereotype.Component;

/**
 * @author landyl
 * @create 2:57 PM 05/09/2018
 */
@Component(ValidatorConstants.BEAN_NAME_POLICY_BUSINESS_LINE)
public class BusinessLineValidator implements Validator<PolicyRequestDetail,PolicyRequestFile> {

    public String doValidate(PolicyRequestDetail detail, PolicyRequestFile file, ValidatorChain chain) throws BusinessValidationException {
        String result = validateBusinessLineLogic(detail);

        if(!Constants.VALID.equals(result)){
            return result;
        }

        result = validateBaseInfoByBusinessLine(detail);

        if(!Constants.VALID.equals(result)){
            return result;
        }
        return chain.doValidate(detail,file);
    }

    private String validateBusinessLineLogic(PolicyRequestDetail detail) {
        if(detail.getBusinessLine() == null || detail.getBusinessLine().trim().isEmpty()){
            return "BusinessLine is required!";
        }

        String businessLineTrim = detail.getBusinessLine().trim();
        if(businessLineTrim.length() !=1 || "012".indexOf(businessLineTrim) == -1){
            return "Invalid Business Line! An invalid Business Line setting was provided. Accepted Value(s): 0, 1, 2 (0 = Individual, 1 = Small Medium Group, 2 = Medicare).";
        }

        if("1".equals(businessLineTrim)){
            String groupName = detail.getGroupName();
            String policyNumber = detail.getPolicyNumber();

            if((groupName == null || groupName.trim().isEmpty())
                    && (policyNumber == null || policyNumber.trim().isEmpty())){
                return "Not enough details for the SMB policy identification process to proceed or no update details provided. POLICY_NUMBER or GROUP_NAME must be provided.";
            }
        }

        return Constants.VALID;
    }

    private String validateBaseInfoByBusinessLine(PolicyRequestDetail detail) {
        String result;
        if("1".equals(detail.getBusinessLine())){
            result = validateSMBBasicInfo(detail);
        } else {
            result = validateINDAndMDCBasicInfo(detail);
        }
        return result;
    }

    private String validateSMBBasicInfo(PolicyRequestDetail detail) {
        return Constants.VALID;
    }

    private String validateINDAndMDCBasicInfo(PolicyRequestDetail detail) {
        if (StringUtils.isEmpty(detail.getPolicyId())
                && (StringUtils.isEmpty(detail.getApplicationId()) || StringUtils.isEmpty(detail.getMemberNumber()))
                && StringUtils.isEmpty(detail.getFullName())
                && (StringUtils.isEmpty(detail.getFirstName()) || StringUtils.isEmpty(detail.getLastName()))
                && StringUtils.isEmpty(detail.getPolicyNumber())) {
            return "Not enough details for the IND/MDC policy identification process to proceed or no update details provided.";
        }
        return Constants.VALID;
    }

}
