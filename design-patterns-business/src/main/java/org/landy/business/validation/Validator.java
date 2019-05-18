package org.landy.business.validation;

import org.landy.business.domain.detail.RequestDetail;
import org.landy.business.domain.file.RequestFile;
import org.landy.exception.BusinessValidationException;

/**
 * 业务校验统一接口
 * @author landyl
 * @create 10:32 AM 05/09/2018
 * @version 1.0
 * @since 1.0
 */
public interface Validator<R extends RequestDetail,F extends RequestFile> {

    String doValidate(R detail, F file, ValidatorChain chain) throws BusinessValidationException;

}
