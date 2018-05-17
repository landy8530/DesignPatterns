package org.landy.business;

import org.landy.business.domain.file.RequestFile;
import org.landy.business.validation.facade.RequestFileValidationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestValidator {

    @Autowired
    private RequestFileValidationFacade requestValidationFacade;

    public String validateFileInfo(RequestFile file) {
        return requestValidationFacade.validateFileInfo(file);
    }

    public String validateSummary(RequestFile file) {
        return requestValidationFacade.validateSummary(file);
    }

    public String validateHeaders(RequestFile file) {
        return requestValidationFacade.validateHeaders(file);
    }

    public String validateDetails(RequestFile file) {
        return requestValidationFacade.validateDetails(file);
    }
}
