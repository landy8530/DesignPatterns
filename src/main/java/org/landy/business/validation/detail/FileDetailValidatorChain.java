package org.landy.business.validation.detail;

import org.landy.business.domain.detail.RequestDetail;
import org.landy.business.domain.file.RequestFile;
import org.landy.business.enums.WorkflowEnum;
import org.landy.business.validation.Validator;
import org.landy.business.validation.ValidatorChain;
import org.landy.constants.Constants;
import org.landy.exception.BusinessValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author landyl
 * @create 10:41 AM 05/09/2018
 */
@Component
public class FileDetailValidatorChain implements ValidatorChain {

    Map<WorkflowEnum,List<Validator>> validatorMap = new HashMap<>();
    /**
     * The int which is used to maintain the current position int the validator chain
     */
    private int index = 0;

    private WorkflowEnum workflowId;

    @Override
    public String doValidate(RequestDetail requestDetail, RequestFile requestFile) throws BusinessValidationException {
        List<Validator> validators = validatorMap.get(workflowId);

        if(index == validators.size()) return Constants.VALID;

        Validator validator = validators.get(index);
        index ++;

        return validator.doValidate(requestDetail,requestFile,this);
    }

    @Override
    public ValidatorChain addValidator(Validator validator,WorkflowEnum workflowId) {
        // Prevent the same filter being added multiple times
        List<Validator> validators ;
        if(validatorMap.containsKey(workflowId)) {
            validators = validatorMap.get(workflowId);
        } else {
            validators = new ArrayList<>(0);
        }

        for(Validator v : validators) {
            if(v.equals(validator)) {
                return this;
            }
        }

        validators.add(validator);

        validatorMap.put(workflowId,validators);
        return this;
    }

    public WorkflowEnum getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(WorkflowEnum workflowId) {
        this.workflowId = workflowId;
    }
}
