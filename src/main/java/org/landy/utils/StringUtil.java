package org.landy.utils;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class StringUtil {

    public static final String PATTERN_INTEGER = "-?[0-9]+";
    public static final String PATTERN_DECIMAL = "-?[0-9]+\\.?[0-9]+";

    public static final String FORMAT_DOLLAR = "$###,##0.00";

    public static boolean isInteger(String str) {
        if (StringUtils.isEmpty(str)) return false;

        return str.matches(PATTERN_INTEGER);
    }

    public static boolean isDecimal(String str) {
        if (StringUtils.isEmpty(str)) return false;

        return str.matches(PATTERN_DECIMAL);
    }

    public static boolean isNumber(String str) {
        return isInteger(str) || isDecimal(str);
    }

    public static Integer string2Integer(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static BigDecimal string2Decimal(String str) {
        try {
            return new BigDecimal(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String formatDollar(String str) {
        DecimalFormat df = new DecimalFormat(FORMAT_DOLLAR);
        return df.format(string2Decimal(str));
    }

    public static String removeSpecialCharacter(String str){
        return str.replaceAll("[^a-zA-Z\\s]", "");
    }

}
