package org.landy.business.validation.facade;

import org.landy.business.domain.detail.RequestDetail;
import org.landy.business.domain.file.RequestFile;
import org.landy.business.enums.WorkflowEnum;
import org.landy.business.validation.handler.AbstractValidatorHandler;
import org.springframework.stereotype.Component;

/**
 * @author landyl
 * @create 4:27 PM 05/17/2018
 */
@Component
public class RequestDetailValidationFacade {

    public String validate(RequestDetail requestDetail, RequestFile requestFile) {
        return accessValidator(requestFile).validate(requestDetail,requestFile);
    }

    private AbstractValidatorHandler accessValidator(RequestFile requestFile) {
        AbstractValidatorHandler requestValidation = AbstractValidatorHandler.accessValidatorHandler(requestFile.getProcessWorkFlow());
        return requestValidation;
    }

}
