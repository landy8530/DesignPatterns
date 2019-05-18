package org.landy.business.validation.detail.common;

import org.apache.commons.lang.StringUtils;
import org.landy.business.domain.detail.RequestDetail;
import org.landy.business.domain.file.RequestFile;
import org.landy.business.validation.Validator;
import org.landy.business.validation.ValidatorConstants;
import org.landy.constants.Constants;
import org.landy.exception.BusinessValidationException;
import org.springframework.stereotype.Component;

/**
 * @author landyl
 * @create 2:57 PM 05/09/2018
 */
@Component(ValidatorConstants.BEAN_NAME_GENDER)
public class GenderValidator implements Validator<RequestDetail, RequestFile> {

    @Override
    public boolean doValidate(RequestDetail detail, RequestFile file) throws BusinessValidationException {
        if (StringUtils.isNotEmpty(detail.getGender()) && !"M".equals(detail.getGender()) && !"F".equals(detail.getGender())) {
            String result = "An invalid Gender setting was provided. Accepted Value(s): M, F (M = Male; F = Female).";
            detail.bindValidationResult(Constants.INVALID_GENDER,result);
            return false;
        }
        return true;
    }
}
