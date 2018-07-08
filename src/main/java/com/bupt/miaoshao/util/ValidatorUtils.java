package com.bupt.miaoshao.util;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtils {

    private static String mobileRegex = "1\\d{10}";

    private static final Pattern mobilePattern = Pattern.compile(mobileRegex);

    public static boolean isMoblie(String str) {
        if(!StringUtils.isEmpty(str)) {
            Matcher matcher = mobilePattern.matcher(str);

            return matcher.matches();
        }
        return false;
    }
}
