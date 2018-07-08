package com.bupt.miaoshao.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;


    public<T> boolean set(KeyPrefix prefix, String key, T data) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String objStr = getStrFromObj(data);
            String realKey = prefix.getPrefix() +"."+key;
            int time = prefix.getExpireSeconds();
            if(time <= 0) {
                jedis.set(realKey, objStr);
            } else {
                jedis.setex(realKey, time, objStr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis != null)
                jedis.close();
            return true;
        }
    }

    public<T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        T t = null;
        try{
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() +"."+key;
            String obj = jedis.get(realKey);
            t = getObjFromStr(obj, clazz);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedisPool != null)
                jedis.close();
            return t;
        }

    }

    public<T> boolean isExisted(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        boolean isExist = false;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() +"."+key;
            isExist = jedis.exists(realKey);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis != null)
                jedis.close();
            return isExist;
        }
    }

    public<T> Long inc(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        Long result = 0L;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() +"."+key;
            result = jedis.incr(realKey);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis != null)
                jedis.close();
            return result;
        }
    }

    public<T> Long decr(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        Long result = 0L;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() +"."+key;
            result = jedis.decr(realKey);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis != null)
                jedis.close();
            return result;
        }
    }


    private <T> T getObjFromStr(String str, Class<T> clazz) {

        if(str == null || str.length() == 0) {
            return null;
        }
        if(clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(str);
        }
        if(clazz == String.class) {
            return (T)str;
        }

        return JSON.toJavaObject(JSON.parseObject(str), clazz);
    }

    private<T> String getStrFromObj(T t) {
        if(t == null ) {
            return null;
        }
        Class<?> clazz = t.getClass();
        if(clazz == int.class || clazz == long.class) {
            return "" + t;
        }
        return JSON.toJSONString(t);
    }
}
