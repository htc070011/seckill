package com.bupt.miaoshao.redis;

public class UserPrefix extends BasePrefix{

    private UserPrefix(String prefix) {
        super(prefix);
    }

    public static UserPrefix getById = new UserPrefix("id");

    public static UserPrefix getByName = new UserPrefix("name");
}
