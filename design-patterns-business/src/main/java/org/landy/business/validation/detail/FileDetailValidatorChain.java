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
    Map<WorkflowEnum,Integer> validatorIndexMap = new HashMap<>();
    /**
     * The int which is used to maintain the current position int the validator chain
     */
    private int index = 0;

    private WorkflowEnum workflowId;

    @Override
    public String doValidate(RequestDetail requestDetail, RequestFile requestFile) throws BusinessValidationException {
        List<Validator> validators = validatorMap.get(workflowId);
        //防止第二次文件校验的时候出现index没有重新设置为0
        //并且每个业务流程的index应该是独立的
        if(validatorIndexMap.containsKey(workflowId)) {
            index = validatorIndexMap.get(workflowId) == null ? 0 : validatorIndexMap.get(workflowId);
        } else {
            index = 0;
        }


        if(index == validators.size()) return Constants.VALID;

        Validator validator = validators.get(index);
        index ++;

        validatorIndexMap.put(workflowId,index);

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

    public void doClearValidatorIndex(WorkflowEnum workflowId) {
        if(validatorIndexMap.containsKey(workflowId)) {
            validatorIndexMap.put(workflowId,0);
        }
    }

    public WorkflowEnum getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(WorkflowEnum workflowId) {
        this.workflowId = workflowId;
    }
}
