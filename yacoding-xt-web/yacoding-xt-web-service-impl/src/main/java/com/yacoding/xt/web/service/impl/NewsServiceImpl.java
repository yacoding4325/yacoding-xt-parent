package com.yacoding.xt.web.service.impl;

import com.yacoding.xt.common.model.CallResult;
import com.yacoding.xt.common.service.AbstractTemplateAction;
import com.yacoding.xt.web.domain.NewsDomain;
import com.yacoding.xt.web.domain.repository.NewsDomainRepository;
import com.yacoding.xt.web.model.params.NewsParam;
import com.yacoding.xt.web.service.NewsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl extends AbstractService implements NewsService {

    @Autowired
    private NewsDomainRepository newsDomainRepository;

    @Override
    public CallResult newsList(NewsParam newsParam) {
        NewsDomain newsDomain = newsDomainRepository.createDomain(newsParam);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> checkParam() {
                //参数检测
                return newsDomain.checkNewsListParam();
            }
            @Override
            public CallResult<Object> doAction() {
                return newsDomain.newsList();
            }
        });
    }

    @Override
    public CallResult findNewsById(NewsParam newsParam) {
        NewsDomain newsDomain = newsDomainRepository.createDomain(newsParam);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return newsDomain.findNewsById();
            }
        });
    }
}