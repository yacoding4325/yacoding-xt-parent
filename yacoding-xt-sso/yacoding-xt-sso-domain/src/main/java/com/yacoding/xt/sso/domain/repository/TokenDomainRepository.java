package com.yacoding.xt.sso.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author yaCoding
 * @create 2022-04-19 下午 3:56
 */

@Component
public class TokenDomainRepository {

    @Autowired
    public StringRedisTemplate redisTemplate;//使用

    public TokenDomain createDomain() {
        return  new TokenDomain(this);
    }
}
