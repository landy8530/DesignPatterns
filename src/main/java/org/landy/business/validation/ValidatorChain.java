package org.landy.business.validation;

import org.landy.business.domain.detail.RequestDetail;
import org.landy.business.domain.file.RequestFile;
import org.landy.business.enums.WorkflowEnum;
import org.landy.exception.BusinessValidationException;

/**
 * @author landyl
 * @create 10:36 AM 05/09/2018
 */
public interface ValidatorChain<T extends RequestDetail,F extends RequestFile> {

    String doValidate(T requestDetail, F requestFile) throws BusinessValidationException;

    ValidatorChain addValidator(Validator validator, WorkflowEnum workflowId);
}
