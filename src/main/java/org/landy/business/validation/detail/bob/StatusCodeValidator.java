package org.landy.business.validation.detail.bob;

import org.apache.commons.lang.StringUtils;
import org.landy.business.domain.detail.BOBRequestDetail;
import org.landy.business.domain.file.BOBRequestFile;
import org.landy.business.validation.Validator;
import org.landy.business.validation.ValidatorChain;
import org.landy.business.validation.ValidatorConstants;
import org.landy.exception.BusinessValidationException;
import org.springframework.stereotype.Component;

/**
 * @author landyl
 * @create 2:57 PM 05/09/2018
 */
@Component(ValidatorConstants.BEAN_NAME_BOB_STATUS_CODE)
public class StatusCodeValidator implements Validator<BOBRequestDetail,BOBRequestFile> {

    public String doValidate(BOBRequestDetail detail, BOBRequestFile file, ValidatorChain chain) throws BusinessValidationException {
        if (StringUtils.isEmpty(detail.getStatusCode())) {
            return "Status Code is required.";
        }
        return chain.doValidate(detail,file);
    }

}
