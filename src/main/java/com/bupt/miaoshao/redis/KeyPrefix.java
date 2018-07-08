package com.bupt.miaoshao.redis;

public interface KeyPrefix {

    int getExpireSeconds();

    String getPrefix();
}
