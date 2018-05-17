package org.landy.business.validation;

import org.apache.commons.lang.StringUtils;
import org.landy.business.domain.detail.BOBRequestDetail;
import org.landy.business.domain.file.RequestFile;
import org.landy.business.enums.WorkflowEnum;
import org.landy.business.validation.handler.BOBValidatorHandler;
import org.landy.business.constants.Constants;
import org.landy.utils.DateUtil;
import org.landy.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author landyl
 * @create 2:37 PM 05/07/2018
 */
@Component(value = BOBRequestValidation.BEAN_NAME)
public class BOBRequestValidation extends AbstractRequestValidation {
    public static final String BEAN_NAME = "bobRequestValidation";

    @Override
    protected String validateFileName(String fileName) {
        if (StringUtils.isEmpty(fileName)) return generateFileNameResult();

        int index = 0;
        String[] nameParts = fileName.split(Constants.DELIMITER_UNDERSCORE);
        if (nameParts.length != 6) return generateFileNameResult();

        //csync_bob_integration_yyyyMMdd_HHmmss_count.txt
        if (!"csync".equals(nameParts[index++])) return generateFileNameResult();
        if (!"bob".equals(nameParts[index++])) return generateFileNameResult();
        if (!"integration".equals(nameParts[index++])) return generateFileNameResult();

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
        List<BOBRequestDetail> requestBOBDetails = requestFile.getRequestDetails();
        if (requestBOBDetails == null || requestBOBDetails.size() == 0) {
            return errMsg.append(" No details were provided on the request.");
        }

        for (int i = 0; i < requestBOBDetails.size(); i++) {
            String result = validateBOBDetail(requestBOBDetails.get(i),requestFile);

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
        return WorkflowEnum.BOB;
    }

    @Override
    protected String accessFileNameFormat() {
        return "csync_bob_integration_yyyyMMdd_HHmmss_count.txt";
    }

    @Override
    protected String accessBeanName() {
        return BEAN_NAME;
    }

    private String validateBOBDetail(BOBRequestDetail requestDetail,RequestFile requestFile) {
        return super.validateDetail(requestDetail,requestFile);
    }
}
