package org.landy.business.validation.detail.common;

import org.apache.commons.lang.StringUtils;
import org.landy.business.domain.detail.RequestDetail;
import org.landy.business.domain.file.RequestFile;
import org.landy.business.validation.ValidatorConstants;
import org.landy.business.validation.adapter.ValidatorAdapter;
import org.landy.constants.Constants;
import org.landy.exception.BusinessValidationException;
import org.springframework.stereotype.Component;

/**
 * @author landyl
 * @create 2:57 PM 05/09/2018
 */
@Component(ValidatorConstants.BEAN_NAME_CUSTOMER_IS_REVERSED)
public class IsReversedValidator extends ValidatorAdapter {

    @Override
    public boolean doValidate(RequestDetail detail, RequestFile file) throws BusinessValidationException {
        if (StringUtils.isNotEmpty(detail.getIsReversed())
                && !"0".equals(detail.getIsReversed())
                && !"1".equals(detail.getIsReversed())) {
            String result = "An invalid Is Reversed setting was provided. Accepted Value(s): 0, 1 (0 = No; 1 = Yes).";
            detail.bindValidationResult(Constants.INVALID_IS_REVERSED,result);
            return false;
        }
        return true;
    }
}
