package org.landy.business.validation.adapter;

import org.landy.business.domain.detail.RequestDetail;
import org.landy.business.domain.file.RequestFile;
import org.landy.business.validation.Validator;
import org.landy.business.validation.ValidatorChain;
import org.landy.exception.BusinessValidationException;

/**
 * @author: landy
 * @date: 2019/5/19 14:48
 * @description:
 */
public abstract class ValidatorAdapter implements Validator<RequestDetail, RequestFile>  {

    public String doValidate(RequestDetail detail, RequestFile file, ValidatorChain chain) throws BusinessValidationException {
        boolean isValid = this.doValidate(detail, file);
        //校验失败了，就直接返回
        if(!isValid) {
            if(detail.getValidationResult() != null) {
                return detail.getValidationResult().getResultMsg();
            }
        }
        //否则往责任链中下一个校验器进行处理
        return chain.doValidate(detail, file);
    }

    @Override
    public boolean doValidate(RequestDetail detail, RequestFile file) throws BusinessValidationException {
        return true;
    }
}
