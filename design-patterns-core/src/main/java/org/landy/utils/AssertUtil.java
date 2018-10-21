package org.landy.utils;

import org.apache.commons.lang.StringUtils;
import org.landy.exception.BusinessValidationException;

import java.util.List;

public class AssertUtil {
    private static final String INVALID_CHARS = ";()~!@#$%^&*:<>/\\=+{}[]|";

    public static void assertNotNull(Object obj, String fieldName) {
        assertNotNull(obj, fieldName, false);
    }

    public static void assertNotNull(Object obj, String fieldName, boolean isJsonFormat) {
        if (obj == null) {
            throw new BusinessValidationException(String.format("%s must be not null.", fieldName));
        }
    }

    public static void assertNotEmpty(String str, String fieldName) {
        assertNotEmpty(str, fieldName, false);
    }

    public static void assertNotEmpty(String str, String fieldName, boolean isJsonFormat) {
        if (str == null || str.trim().length() == 0) {
            throw new BusinessValidationException(String.format("%s must be not null or empty.", fieldName));
        }
    }

    public static void assertNotEmptyList(List list, String message) {
        assertNotEmptyList(list, message, false);
    }

    public static void assertNotEmptyList(List list, String message, boolean isJsonFormat) {
        if (list == null || list.isEmpty()) {
            throw new BusinessValidationException(message);
        }
    }

    public static void assertTrue(boolean bool, String message) {
        assertTrue(bool, message, false);
    }

    public static void assertTrue(boolean bool, String message, boolean isJsonFormat) {
        if (!bool) {
            throw new BusinessValidationException(message);
        }
    }

    public static void assertValidString(String str) {
        assertValidString(str, false);
    }

    public static void assertValidString(String str, boolean isJsonFormat) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        for (char c : str.toCharArray()) {
            if (StringUtils.contains(INVALID_CHARS, c)) {
                throw new BusinessValidationException("Invalid characters input.");
            }
        }
    }

    public static void matchPattern(String text, String pattern, String msg) {
        matchPattern(text, pattern, msg, false);
    }

    public static void matchPattern(String text, String pattern, String msg, boolean isJsonFormat) {
        if (!text.matches(pattern)) {
            throw new BusinessValidationException(msg);
        }
    }
}
