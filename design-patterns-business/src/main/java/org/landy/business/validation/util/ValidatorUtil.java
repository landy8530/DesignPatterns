package org.landy.business.validation.util;

import org.landy.business.domain.detail.PolicyRequestDetail;
import org.landy.business.validation.ValidatorConstants;
import org.landy.business.validation.detail.common.GenderValidator;
import org.landy.business.validation.detail.common.IsActiveValidator;
import org.landy.business.validation.detail.common.IsReversedValidator;
import org.landy.business.validation.detail.common.NotCancelledValidator;
import org.landy.constants.Constants;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author landyl
 * @create 8:57 05/15/2019
 */
public final class ValidatorUtil {

    /**
     * 取得约束字段校验器所有的校验器Class对象列表
     * @see org.landy.business.validation.detail.customer.ConstrainedColumnValidator
     * @return
     */
    public static Set<Class> constrainedColumnValidatorClasses() {
        Map<String, Class> classMap = constrainedColumnValidatorClassMap();
        Set<Class> classes = new HashSet(classMap.values());
        return classes;
    }

    /**
     * 取得约束字段校验器包含的Class Map
     * @return
     */
    public static Map<String,Class> constrainedColumnValidatorClassMap() {
        Map<String, Class> classMap = new HashMap<>();
        ConstrainedColumn constrainedColumns[] = ConstrainedColumn.values();
        for(ConstrainedColumn constrainedColumn : constrainedColumns) {
            classMap.put(constrainedColumn.beanName,constrainedColumn.validatorClass);
        }
        return classMap;
    }

    /**
     * 取得约束字段校验结果id
     * @param beanName
     * @return
     */
    public static int getConstrainedColumnResultId(String beanName) {
        ConstrainedColumn constrainedColumns[] = ConstrainedColumn.values();
        for(ConstrainedColumn constrainedColumn : constrainedColumns) {
            if(constrainedColumn.beanName.equals(beanName)) {
                return constrainedColumn.resultId;
            }
        }
        return Constants.UNPROCESSED;
    }

    /**
     * 取得约束字段名称
     * @param beanName
     * @return
     */
    public static String getConstrainedColumnName(String beanName) {
        ConstrainedColumn constrainedColumns[] = ConstrainedColumn.values();
        for(ConstrainedColumn constrainedColumn : constrainedColumns) {
            if(constrainedColumn.beanName.equals(beanName)) {
                return constrainedColumn.columnName;
            }
        }
        return Constants.EMPTY_STRING;
    }

    public static void setNullIfInvalid(PolicyRequestDetail detail, String columnName) {
        Field dataField = ReflectionUtils.findField(PolicyRequestDetail.class,columnName);
        ReflectionUtils.makeAccessible(dataField);
        ReflectionUtils.setField(dataField,detail,null);
    }

    enum ConstrainedColumn {
        IS_ACTIVE(ValidatorConstants.BEAN_NAME_CUSTOMER_IS_ACTIVE,IsActiveValidator.class,"isActive", Constants.INVALID_IS_ACTIVE),
        IS_REVERSED(ValidatorConstants.BEAN_NAME_CUSTOMER_IS_REVERSED,IsReversedValidator.class,"isReversed", Constants.INVALID_IS_REVERSED),
        NOT_CANCELLED(ValidatorConstants.BEAN_NAME_CUSTOMER_REVENUE_NOT_CANCELLED,NotCancelledValidator.class,"notCancelled", Constants.INVALID_NOT_CANCELLED),
        GENDER(ValidatorConstants.BEAN_NAME_GENDER,GenderValidator.class,"gender", Constants.INVALID_GENDER),

        ;

        /**
         * 校验类bean name
         */
        private String beanName;
        /**
         * 校验类对应的Class对象
         */
        private Class validatorClass;
        /**
         * 需要校验的目标字段名称
         */
        private String columnName;
        /**
         * 校验结果id
         */
        private int resultId;

        ConstrainedColumn(String beanName, Class validatorClass, String columnName, int resultId) {
            this.beanName = beanName;
            this.validatorClass = validatorClass;
            this.columnName = columnName;
            this.resultId = resultId;
        }
    }
}
