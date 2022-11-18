package com.itau.appjwtvalidator.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidatingUtils {

    public static boolean onlyNumbers(String value) {
        if (value == null) {
            return false;
        }
        return value.matches("[0-9]+");
    }

    public static boolean maxLength(String value, Integer maxLength) {
        if (value == null || maxLength == null) {
            return false;
        }
        return value.length() <= maxLength;
    }

    public static boolean mustHaveLength(String value, Integer maxLength) {
        if (value == null || maxLength == null) {
            return false;
        }
        return value.length() == maxLength;
    }

}
