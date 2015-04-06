package com.huang.j2ee.ch00;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created By User : Morn
 * Created DateTime: 2015/2/7 11:07
 * Descriptions    : 测试加密
 */
public class Encryption {
    public static String encrypt(String key) throws Exception
    {
        String algorithm = System.getProperty("digester.algorithm", "SHA");
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] buffer = key.getBytes("ISO8859_1");
        md.update(buffer, 0, buffer.length);
        byte[] digest = md.digest();
        BigInteger bigint = new BigInteger(1, digest);
        String str = bigint.toString();
        return str;
    }

    public static void main(String[] args) {
        try {
            System.out.println(Encryption.encrypt("123456"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
