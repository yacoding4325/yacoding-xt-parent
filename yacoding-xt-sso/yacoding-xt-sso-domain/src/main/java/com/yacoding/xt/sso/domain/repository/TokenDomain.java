package com.yacoding.xt.sso.domain.repository;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yacoding.xt.common.constants.RedisKey;
import com.yacoding.xt.common.utils.JwtUtil;
import com.yacoding.xt.sso.domain.LoginDomain;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author yaCoding
 * @create 2022-04-19 下午 3:57
 */

@Slf4j
public class TokenDomain {

    private TokenDomainRepository tokenDomainRepository;

    public TokenDomain(TokenDomainRepository tokenDomainRepository) {
        this.tokenDomainRepository = tokenDomainRepository;
    }

    public Long checkToken(String token) {
        /**
         *1.检测token字符串是否合法
         *2.检测redis是否有此token
         */

        try {
            JwtUtil.parseJWT(token, LoginDomain.secretKey);//解析token
            String userIdStr = tokenDomainRepository.redisTemplate.opsForValue().get(RedisKey.TOKEN + token);
            if (StringUtils.isBlank(userIdStr)) {
                //如果userIdStr为null
                return null;
            }
            return Long.parseLong(userIdStr);//拿到所需的userIdStr的认证
        } catch (Exception e){
            e.printStackTrace();
            log.error("checkToken error:{}",e.getMessage(),e);
            //打印一些错误日志信息，方便查询
            return null;
        }
    }
}
