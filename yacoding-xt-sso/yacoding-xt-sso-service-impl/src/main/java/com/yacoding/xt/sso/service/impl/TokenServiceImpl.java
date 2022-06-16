package com.yacoding.xt.sso.service.impl;

import com.yacoding.xt.sso.domain.repository.TokenDomain;
import com.yacoding.xt.sso.domain.repository.TokenDomainRepository;
import com.yacoding.xt.sso.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yaCoding
 * @create 2022-04-19 下午 3:52
 */

@Service
public class TokenServiceImpl extends AbstractService implements TokenService {

    @Autowired
    private TokenDomainRepository tokenDomainRepository;

    @Override
    public Long checkToken(String token) {
        TokenDomain tokenDomain = tokenDomainRepository.createDomain();
        return tokenDomain.checkToken(token);
    }
}
