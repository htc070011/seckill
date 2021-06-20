package com.bupt.miaoshao.config;

import com.bupt.miaoshao.redis.RedisConfig;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class MainConfig {

    @Bean
    public JedisPool jedisPool(RedisConfig config) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(config.getPoolMaxIdle());
        jedisPoolConfig.setMaxIdle(config.getPoolMaxIdle());
        jedisPoolConfig.setMaxTotal(config.getPoolMaxTotal() * 1000);
        jedisPoolConfig.setMaxWaitMillis(config.getPoolMaxWait() * 1000);
        return new JedisPool(jedisPoolConfig, config.getHost(), config.getPort(), config.getTimeout() * 1000, null, 0);
    }


}
