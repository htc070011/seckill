package com.bupt.miaoshao.redis;

public class TokenPrefix extends BasePrefix {

    private static final int expiredTime = 3600 * 10;

    private TokenPrefix(int expireSeconds, String token) {
        this.expireSeconds = expireSeconds;
        this.prefix = token;
    }

    public static TokenPrefix tokenPrefix = new TokenPrefix(expiredTime, "token");
}
