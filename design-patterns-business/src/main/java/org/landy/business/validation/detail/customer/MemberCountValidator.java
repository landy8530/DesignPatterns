package org.landy.business.validation.detail.customer;

import org.apache.commons.lang.StringUtils;
import org.landy.business.domain.detail.CustomerRequestDetail;
import org.landy.business.domain.file.CustomerRequestFile;
import org.landy.business.validation.Validator;
import org.landy.business.validation.ValidatorChain;
import org.landy.business.validation.ValidatorConstants;
import org.landy.exception.BusinessValidationException;
import org.landy.utils.StringUtil;
import org.springframework.stereotype.Component;

/**
 * @author landyl
 * @create 2:57 PM 05/09/2018
 */
@Component(ValidatorConstants.BEAN_NAME_CUSTOMER_MEMBER_COUNT)
public class MemberCountValidator implements Validator<CustomerRequestDetail, CustomerRequestFile> {

    public String doValidate(CustomerRequestDetail detail, CustomerRequestFile file, ValidatorChain chain) throws BusinessValidationException {
        if (!isValidMemberCount(detail.getMemberCount())) {
            return "An invalid User count was provided. Accepted Value(s): 0 - 10.";
        }
        return chain.doValidate(detail,file);
    }

    private boolean isValidMemberCount(String value) {
        if (StringUtils.isEmpty(value)) return  true;

        int memberCount = StringUtil.string2Integer(value);
        if (memberCount >= 0 && memberCount <= 10) return true;

        return false;
    }


}
