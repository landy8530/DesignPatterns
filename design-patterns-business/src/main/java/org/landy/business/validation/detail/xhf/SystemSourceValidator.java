package org.landy.business.validation.detail.xhf;

import org.apache.commons.lang.StringUtils;
import org.landy.business.domain.detail.XHFRequestDetail;
import org.landy.business.domain.file.XHFRequestFile;
import org.landy.business.validation.Validator;
import org.landy.business.validation.ValidatorChain;
import org.landy.business.validation.ValidatorConstants;
import org.landy.exception.BusinessValidationException;
import org.springframework.stereotype.Component;

/**
 * @author landyl
 * @create 2:57 PM 05/09/2018
 */
@Component(ValidatorConstants.BEAN_NAME_XHF_SYSTEM_SOURCE)
public class SystemSourceValidator implements Validator<XHFRequestDetail,XHFRequestFile> {

    public String doValidate(XHFRequestDetail detail, XHFRequestFile file, ValidatorChain chain) throws BusinessValidationException {
        if (StringUtils.isEmpty(detail.getSystemSourceId())) {
            return "System Source ID is required when current flow is GMG integration workflow..";
        }
        return chain.doValidate(detail,file);
    }

}
