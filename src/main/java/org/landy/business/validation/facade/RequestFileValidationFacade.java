package org.landy.business.validation.facade;

import org.landy.business.domain.file.RequestFile;
import org.landy.business.enums.WorkflowEnum;
import org.landy.business.validation.AbstractRequestValidation;
import org.springframework.stereotype.Component;

/**
 * @author landyl
 * @create 3:42 PM 05/07/2018
 */
@Component
public class RequestFileValidationFacade {

    public String validateFileInfo(RequestFile requestFile) {
        return accessRequestValidation(requestFile).validateFileInfo(requestFile);
    }

    public String validateSummary(RequestFile requestFile) {
        return accessRequestValidation(requestFile).validateSummary(requestFile);
    }

    public String validateHeaders(RequestFile requestFile) {
        return accessRequestValidation(requestFile).validateHeaders(requestFile);
    }

    public String validateDetails(RequestFile requestFile) {
        return accessRequestValidation(requestFile).validateDetails(requestFile);
    }


    private AbstractRequestValidation accessRequestValidation(RequestFile requestFile) {
        WorkflowEnum workflowId = requestFile.getProcessWorkFlow();
        AbstractRequestValidation requestValidation = AbstractRequestValidation.accessRequestValidationHandler(workflowId);
        return requestValidation;
    }
}
