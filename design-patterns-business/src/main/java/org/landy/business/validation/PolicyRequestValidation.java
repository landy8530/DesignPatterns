package org.landy.business.validation;

import org.apache.commons.lang.StringUtils;
import org.landy.business.domain.detail.PolicyRequestDetail;
import org.landy.business.domain.file.RequestFile;
import org.landy.business.enums.WorkflowEnum;
import org.landy.constants.Constants;
import org.landy.utils.DateUtil;
import org.landy.utils.StringUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author landyl
 * @create 2:31 PM 05/07/2018
 */
@Component(value = PolicyRequestValidation.BEAN_NAME)
public class PolicyRequestValidation extends AbstractRequestValidation {
    public static final String BEAN_NAME = "policyRequestValidation";

    @Override
    protected String validateFileName(String fileName) {
        if (StringUtils.isEmpty(fileName)) return generateFileNameResult();

        int index = 0;
        String[] nameParts = fileName.split(Constants.DELIMITER_UNDERSCORE);
        if (nameParts.length != 5) return generateFileNameResult();

        //xhf_policy_yyyyMMdd_HHmmss_count.txt
        if (!"xhf".equals(nameParts[index++])) return generateFileNameResult();
        if (!"customer".equals(nameParts[index++])) return generateFileNameResult();

        String creationDateStr = nameParts[index++] + "_" + nameParts[index++];
        if (!DateUtil.isValidDate(creationDateStr, DateUtil.DATE_TIME_PATTERN_1)) {
            return generateFileNameResult();
        }

        String countStr = nameParts[index++];
        int dotPosition = countStr.indexOf(".");
        if (dotPosition < 0) return generateFileNameResult();

        if (!StringUtil.isInteger(countStr.substring(0, dotPosition))) {
            return generateFileNameResult();
        }

        if (!Constants.FILE_TYPE_TXT.equals(countStr.substring(dotPosition + 1).toLowerCase())) {
            return generateFileNameResult();
        }

        return Constants.VALID;
    }

    @Override
    protected StringBuilder validateFileDetails(StringBuilder errMsg, RequestFile requestFile) {
        List<PolicyRequestDetail> requestPolicyDetails = requestFile.getRequestDetails();
        if (requestPolicyDetails == null || requestPolicyDetails.size() == 0) {
            return errMsg.append(" No update details were provided on the request.");
        }

        for (int i = 0; i < requestPolicyDetails.size(); i++) {
            String result = validatePolicyDetail(requestPolicyDetails.get(i),requestFile);

            if (Constants.VALID.equals(result)) continue;

            errMsg.append("\n").append("Row " + (i + 1) + " - ").append(result);

            if (errMsg.length() > Constants.NOTE_LENGTH_LIMIT) {
                return new StringBuilder(errMsg.substring(0, Constants.NOTE_LENGTH_LIMIT));
            }
        }

        return errMsg;
    }

    @Override
    protected WorkflowEnum accessWorkflow() {
        return WorkflowEnum.POLICY;
    }

    @Override
    protected String accessFileNameFormat() {
        return "xhf_policy_yyyyMMdd_HHmmss_count.txt";
    }

    @Override
    protected String accessBeanName() {
        return BEAN_NAME;
    }

    private String validatePolicyDetail(PolicyRequestDetail requestDetail,RequestFile requestFile) {
        return super.validateDetail(requestDetail,requestFile);
    }

}
