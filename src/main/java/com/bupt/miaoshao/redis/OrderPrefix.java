package com.bupt.miaoshao.redis;

public class OrderPrefix extends BasePrefix {

    private OrderPrefix(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }


}
