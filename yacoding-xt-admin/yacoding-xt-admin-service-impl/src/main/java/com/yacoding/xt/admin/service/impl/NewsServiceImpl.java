package com.yacoding.xt.admin.service.impl;


import com.yacoding.xt.admin.domain.NewsDomain;
import com.yacoding.xt.admin.domain.repository.NewsDomainRepository;
import com.yacoding.xt.admin.params.NewsParam;
import com.yacoding.xt.admin.service.NewsService;
import com.yacoding.xt.common.model.CallResult;
import com.yacoding.xt.common.service.AbstractTemplateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NewsServiceImpl extends AbstractService implements NewsService {

    @Autowired
    private NewsDomainRepository newsDomainRepository;

    @Override
    public CallResult findPage(NewsParam newsParam) {

        NewsDomain newsDomain = newsDomainRepository.createDomain(newsParam);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {

            @Override
            public CallResult<Object> doAction() {
                return newsDomain.findNewsPage();
            }
        });
    }

    @Override
    @Transactional
    public CallResult save(NewsParam newsParam) {
        NewsDomain newsDomain = newsDomainRepository.createDomain(newsParam);
        return this.serviceTemplate.execute(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return newsDomain.save();
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

    @Override
    @Transactional
    public CallResult update(NewsParam newsParam) {
        NewsDomain newsDomain = newsDomainRepository.createDomain(newsParam);
        return this.serviceTemplate.execute(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return newsDomain.update();
            }
        });
    }

    @Override
    public CallResult upload(MultipartFile file) {
        NewsDomain newsDomain = newsDomainRepository.createDomain(new NewsParam());
        return newsDomain.upload(file);
    }
}
