package com.mmall.util;

import java.security.MessageDigest;

/**
 * @author Timber
 * @date 2018/10/12
 */
public class Md5Util {

    private static final String[] HEX_DIGITS = new String[]{"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String byteArrayToHexString(byte[] bs) {
        StringBuilder resultSb = new StringBuilder();
        for (byte b : bs) {
            resultSb.append(byteToHexString(b));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }

    /**
     * 返回大写 MD5
     * @param origin 原来的 MD5
     * @param charsetName 编码格式名
     * @return String
     */
    private static String md5Encode(String origin, String charsetName) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetName == null || "".equals(charsetName)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetName)));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return resultString.toUpperCase();
    }

    public static String md5EncodeUtf8(String origin) {
        origin = origin + PropertiesUtil.getProperty("password.salt", "");
        return md5Encode(origin, "utf-8");
    }

    public static String md5EncodeGBK(String origin) {
        return md5Encode(origin, "gbk");
    }

}
