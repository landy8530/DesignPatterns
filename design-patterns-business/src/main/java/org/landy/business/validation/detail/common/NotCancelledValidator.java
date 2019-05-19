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
@Component(ValidatorConstants.BEAN_NAME_CUSTOMER_REVENUE_NOT_CANCELLED)
public class NotCancelledValidator extends ValidatorAdapter {

    @Override
    public boolean doValidate(RequestDetail detail, RequestFile file) throws BusinessValidationException {
        if (StringUtils.isNotEmpty(detail.getNotCancelled())
                && !"1".equals(detail.getNotCancelled())) {
            String result = "An invalid Not Cancelled setting was provided. Accepted Value(s): 1 (1 = Yes).";
            detail.bindValidationResult(Constants.INVALID_NOT_CANCELLED,result);
            return false;
        }

        return true;
    }
}
