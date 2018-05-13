package org.landy.business.validation.util;

import org.landy.constants.Constants;
import org.landy.utils.BeanUtil;
import org.landy.utils.CamelCaseUtil;
import org.landy.utils.DateUtil;
import org.landy.utils.StringUtil;

import java.math.BigDecimal;

/**
 * @author landyl
 * @create 5:23 PM 05/09/2018
 */
public class DataTypeUtil {

    public static boolean isValidDataType(String value, Class type) {
        if (org.apache.commons.lang.StringUtils.isEmpty(value)) return true;

        if (Integer.class.equals(type)) {
            return StringUtil.isInteger(value);
        }

        if (Long.class.equals(type)) {
            return StringUtil.isNumber(value);
        }

        if (BigDecimal.class.equals(type)) {
            return StringUtil.isInteger(value) || StringUtil.isDecimal(value);
        }

        if (java.sql.Date.class.equals(type)) {
            return DateUtil.isValidDate(value, DateUtil.DATE_PATTERN_DEFAULT);
        }

        return true;
    }

    public static String validateDataType(Object detail, Object clazz, String[] headers) {
        String propertyName;
        Object propertyValue;
        Class propertyType;
        for (int i = 0; i < headers.length; i++) {
            propertyName = CamelCaseUtil.toCamelCase(headers[i]);
            propertyValue = BeanUtil.getProperty(detail, propertyName);
            propertyType = BeanUtil.getPropertyType(clazz, propertyName);
            if (propertyValue != null && !isValidDataType(propertyValue.toString(), propertyType)) {
                return "Invalid data type (" + CamelCaseUtil.toCapitalizedCamelCase(headers[i], true) + ") identified during the upload process.";
            }
        }

        return Constants.VALID;
    }

}
