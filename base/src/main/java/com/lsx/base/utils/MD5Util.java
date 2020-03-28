package com.lsx.base.utils;

import java.security.MessageDigest;

/**
 * MD5算法
 */
public class MD5Util {

    /**
     * Compute the MD5 fingerprint of a string.
     *
     * @return the MD5 digest of the input <code>String</code>
     */
    public final static String compute(String inStr) {
        MessageDigest md5 = null;

        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
        }

        char[] charArray = inStr.toCharArray();

        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        if (md5 != null) {
            byte[] md5Bytes = md5.digest(byteArray);

            StringBuffer hexValue = new StringBuffer();

            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }

            return hexValue.toString();
        }
        return null;
    }

    /**
     * MD5解密
     *
     * @param inStr
     * @return
     */
    public final static String str2MD5(String inStr) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = inStr.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
}
