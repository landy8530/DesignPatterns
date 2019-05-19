package org.landy.business.validation.detail.xhf;

import org.apache.commons.lang.StringUtils;
import org.landy.business.domain.detail.RequestDetail;
import org.landy.business.domain.detail.XHFRequestDetail;
import org.landy.business.domain.file.RequestFile;
import org.landy.business.validation.ValidatorChain;
import org.landy.business.validation.ValidatorConstants;
import org.landy.business.validation.adapter.ValidatorAdapter;
import org.landy.exception.BusinessValidationException;
import org.springframework.stereotype.Component;

/**
 * @author landyl
 * @create 2:57 PM 05/09/2018
 */
@Component(ValidatorConstants.BEAN_NAME_XHF_SYSTEM_SOURCE)
public class SystemSourceValidator extends ValidatorAdapter {

    public String doValidate(RequestDetail detail, RequestFile file, ValidatorChain chain) throws BusinessValidationException {
        if(detail instanceof XHFRequestDetail) {
            XHFRequestDetail crd = (XHFRequestDetail) detail;
            if (StringUtils.isEmpty(crd.getSystemSourceId())) {
                return "System Source ID is required when current flow is GMG integration workflow..";
            }
        }
        return chain.doValidate(detail,file);
    }

}
