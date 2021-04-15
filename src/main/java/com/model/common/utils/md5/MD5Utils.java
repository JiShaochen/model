package com.model.common.utils.md5;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * @author Morning JS
 * @date 2017/7/22 下午1:00
 * @desc MD5工具类, 全部接收UTF编码的String
 */
public final class MD5Utils {

    private MD5Utils() { }

    private static final String ALGORITHM_MD5 = "MD5";

    private static final Integer MD5_START_POINT = 8;

    private static final Integer MD5_END_POINT = 24;

    private static final Integer HASH_STRING = 0xFF;


    /**
     * MD5 16bit 小写.
     * @param readyEncryptStr ready encrypt string
     * @return String encrypt result string
     * @throws NoSuchAlgorithmException
     * */
    public static String md5Bit16Lower(String readyEncryptStr) throws Exception {
        if (Objects.nonNull(readyEncryptStr)) {
            return MD5Utils.md5Bit32Lower(readyEncryptStr).substring(MD5_START_POINT, MD5_END_POINT);
        } else {
            return null;
        }
    }

    /**
     * MD5 16bit 大写.
     * @param readyEncryptStr ready encrypt string
     * @return String encrypt result string
     * @throws NoSuchAlgorithmException
     * */
    public static String md5Bit16Upper(String readyEncryptStr) throws Exception {
        if (Objects.nonNull(readyEncryptStr)) {
            return md5Bit16Lower(readyEncryptStr).toUpperCase();
        }
        return "";
    }

    /**
     * MD5 32bit 小写.
     * @param readyEncryptStr ready encrypt string
     * @return String encrypt result string
     * @throws NoSuchAlgorithmException
     * */
    public static String md5Bit32Lower(String readyEncryptStr) throws Exception {
        if (Objects.nonNull(readyEncryptStr)) {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM_MD5);
            md.update(readyEncryptStr.getBytes(StandardCharsets.UTF_8));
            byte[] b = md.digest();
            StringBuilder su = new StringBuilder();
            for (int offset = 0, bLen = b.length; offset < bLen; offset++) {
                String haxHex = Integer.toHexString(b[offset] & HASH_STRING);
                if (haxHex.length() < 2) {
                    su.append("0");
                }
                su.append(haxHex);
            }
            return su.toString();
        } else {
            return null;
        }
    }

    /**
     * MD5 32bit 大写.
     * @param readyEncryptStr ready encrypt string
     * @return String encrypt result string
     * @throws NoSuchAlgorithmException
     * */
    public static String md5Bit32Upper(String readyEncryptStr) throws Exception {
        if (Objects.nonNull(readyEncryptStr)) {
            return md5Bit32Lower(readyEncryptStr).toUpperCase();
        }
        return "";
    }

}
