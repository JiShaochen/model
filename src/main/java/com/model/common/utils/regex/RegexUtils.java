package com.model.common.utils.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/23 下午9:12
 * @desc  正则.
 */
public final class RegexUtils {


   /* private static Pattern chinese = Pattern.compile("[\u4e00-\u9fa5]");*/

    private static final String EMAIL_PATTERN = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";

    private static final String MOBILE_PATTERN = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    private static final String CHINESE_PATTERN = "[\u4e00-\u9fa5]";

    private static final String IP_PATTERN = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
            + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
            + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

    private static final String NUMBER_PATTERN = "[0-9]*";

    private static final String SPECIAL_CHAR = "[a-z]*[A-Z]*\\d*-*_*\\s*";

    private RegexUtils() { }

    /**
     * @param mobiles
     * @return isMobileNO
     * @description 校验手机号是否正确
     */
    public static boolean isMobileNO(String mobiles) {
        Matcher m = Pattern.compile(MOBILE_PATTERN).matcher(mobiles);
        return m.matches();
    }

    /**
     * @param email
     * @return isEmail
     * @description 校验邮箱是否正确
     */
    public static boolean isEmail(String email) {
        Pattern p = Pattern.compile(EMAIL_PATTERN);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * @param value
     * @return isInteger
     * @description 校验是否是整数
     */
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 判断是否含有特殊字符
     * @param text
     * @return boolean true,通过，false，没通过
     */
    public static boolean hasSpecialChar(String text) {
        if (null == text || "".equals(text)) {
            return true;
        }
        if (text.replaceAll(SPECIAL_CHAR, "").length() == 0) {
            // 如果不包含特殊字符
            return false;
        }
        return true;
    }

    /**
     * 判断是否正整数
     * @param number 数字
     * @return boolean true,通过，false，没通过
     */
    public static boolean isNumber(String number) {
        if (null == number || "".equals(number)) {
            return false;
        }
        return number.matches(NUMBER_PATTERN);
    }

    /**
     * 判断是否是正确的IP地址
     * @param ip
     * @return boolean true,通过，false，没通过
     */
    public static boolean isIp(String ip) {
        if (null == ip || "".equals(ip)) {
            return false;
        }
        return ip.matches(IP_PATTERN);
    }


    /**
     * 判断是否含有中文，仅适合中国汉字，不包括标点
     * @param text
     * @return boolean true,通过，false，没通过
     */
    public static boolean isChinese(String text) {
        if (null == text || "".equals(text)) {
            return false;
        }
        Matcher m = Pattern.compile(CHINESE_PATTERN).matcher(text);
        return m.find();
    }

}
