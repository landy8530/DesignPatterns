package org.landy.business.validation;

import org.landy.business.domain.detail.RequestDetail;
import org.landy.business.domain.file.RequestFile;
import org.landy.exception.BusinessValidationException;

/**
 * @author landyl
 * @create 10:32 AM 05/09/2018
 */
public interface Validator<R extends RequestDetail,F extends RequestFile> {

    String doValidate(R detail, F file, ValidatorChain chain) throws BusinessValidationException;

}
