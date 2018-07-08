package com.bupt.miaoshao.redis;

public abstract class BasePrefix implements KeyPrefix {

    protected int expireSeconds;

    protected String prefix;

    public BasePrefix() {
    }

    public BasePrefix(String prefix) {
        this.expireSeconds = 0;
        this.prefix = prefix;
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int getExpireSeconds() {
        return this.expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className +"."+ prefix;
    }
}
