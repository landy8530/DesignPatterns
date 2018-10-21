package org.landy.utils;

import org.apache.commons.lang.StringUtils;
import org.landy.constants.Constants;

public class KeyValueUtil {

    public static String getValue(String keyValueStr) {
        if (StringUtils.isEmpty(keyValueStr)) return null;

        String[] parts = keyValueStr.split(Constants.DELIMITER_COLON);
        if (parts.length != 2) return null;

        return parts[1].trim();
    }

}
