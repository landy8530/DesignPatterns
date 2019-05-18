package org.landy.business.validation.detail.customer;

import org.landy.business.domain.detail.CustomerRequestDetail;
import org.landy.business.domain.file.CustomerRequestFile;
import org.landy.business.validation.Validator;
import org.landy.business.validation.ValidatorChain;
import org.landy.business.validation.ValidatorConstants;
import org.landy.business.validation.handler.CustomerValidatorHandler;
import org.landy.business.validation.util.ValidatorUtil;
import org.landy.exception.BusinessValidationException;
import org.landy.web.utils.ApplicationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

/**
 * 所有的约束字段校验器需要在此校验器中进行逐一进行校验操作，校验的结果，如果不是合法字段，则需要把该字段赋值未NULL，或者默认值。
 * 故而，在执行统一校验操作的时候，需要先把约束字段校验器进行排除（CustomerValidatorHandler），在这个类加入。
 * @author landyl
 * @see CustomerValidatorHandler
 * @create 14:03 05/18/2019
 */
@Component(ValidatorConstants.BEAN_NAME_CONSTRAINED_COLUMN)
public class ConstrainedColumnValidator implements Validator<CustomerRequestDetail, CustomerRequestFile> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConstrainedColumnValidator.class);
    //约束字段校验器集合
    private static final Map<String, Class> CONSTRAINED_COLUMN_VALIDATOR_MAP = ValidatorUtil.constrainedColumnValidatorClassMap();

    @Override
    public String doValidate(CustomerRequestDetail detail, CustomerRequestFile file, ValidatorChain chain) throws BusinessValidationException {
        Set<String> beanNameSet = CONSTRAINED_COLUMN_VALIDATOR_MAP.keySet();

        for (String beanName : beanNameSet) {
            Validator validator = getValidator(beanName);
            //不需要链式调用，只要校验器本身方法调用校验即可
            boolean isValid = validator.doValidate(detail, file);
            if(!isValid) {
                int resultId = ValidatorUtil.getConstrainedColumnResultId(beanName);
                if (detail.getValidationResult() != null) {
                    int validationResultId = detail.getValidationResult().getResultId();
                    if (resultId == validationResultId) {
                        String columnName = ValidatorUtil.getConstrainedColumnName(beanName);
                        LOGGER.warn("Invalid column [{}], we simply set the correspond value is null", columnName);
                        ValidatorUtil.setNullIfInvalid(detail, columnName);
                    }
                }
            }
        }
        return chain.doValidate(detail, file);
    }

    /**
     * @param beanName
     * @return
     */
    private Validator getValidator(String beanName) {
        return ApplicationUtil.getApplicationContext().getBean(beanName, Validator.class);
    }

}
