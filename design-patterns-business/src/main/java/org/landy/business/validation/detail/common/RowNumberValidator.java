package org.landy.business.validation.detail.common;

import org.apache.commons.lang.StringUtils;
import org.landy.business.domain.detail.RequestDetail;
import org.landy.business.domain.file.RequestFile;
import org.landy.business.validation.Validator;
import org.landy.business.validation.ValidatorChain;
import org.landy.business.validation.ValidatorConstants;
import org.landy.exception.BusinessValidationException;
import org.springframework.stereotype.Component;

/**
 * @author landyl
 * @create 11:11 AM 05/09/2018
 */
@Component(ValidatorConstants.BEAN_NAME_ROW_NUM)
public class RowNumberValidator implements Validator {

    @Override
    public String doValidate(RequestDetail requestDetail, RequestFile requestFile, ValidatorChain chain) throws BusinessValidationException {
        if (StringUtils.isEmpty(requestDetail.getRowNumber())) {
            return "Row Number is required.";
        }

        return chain.doValidate(requestDetail,requestFile);
    }
}
