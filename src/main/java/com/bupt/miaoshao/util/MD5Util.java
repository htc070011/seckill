package com.bupt.miaoshao.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    private static final String salt = "1a2b3c4d";


    public static String md5(String data) {
        return DigestUtils.md5Hex(data);
    }


    public static String digestInputPass(String inputPass) {

        String str = salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5);

        return md5(str);
    }
    public static String digestFormPass(String formPass, String salt) {

        String str = salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5);

        return md5(str);
    }

    public static String inputPassToDBPass(String input, String saltDB) {

        String formPass = digestInputPass(input);

        String DBPass = digestFormPass(formPass, saltDB);

        return DBPass;

    }

    public static void main(String[] args) {



        System.out.println(inputPassToDBPass("19940107", "1a2b3c4d"));
    }
}
