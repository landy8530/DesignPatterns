package org.landy.business.validation;

import org.landy.business.domain.detail.RequestDetail;
import org.landy.business.domain.file.RequestFile;
import org.landy.exception.BusinessValidationException;

/**
 * 业务校验统一接口,增加了接口的默认方法实现，这样可以更加方便且自由选择实现接口的哪些方法。
 * @author landyl
 * @create 10:32 AM 05/09/2018
 * @version 2.0
 * @since 1.0
 */
public interface Validator<R extends RequestDetail,F extends RequestFile> {

    /**
     * 需要引入责任链的时候，则采用此方法
     * @param detail
     * @param chain
     * @return
     * @throws BusinessValidationException
     */
    default String doValidate(R detail, F file, ValidatorChain chain) throws BusinessValidationException {
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

    /**
     * 不需要责任链的时候，则可以直接调用此方法的实现即可
     * @param detail
     * @return
     * @throws BusinessValidationException
     */
    default boolean doValidate(R detail, F file) throws BusinessValidationException { return true; }

}
