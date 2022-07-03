package com.yacoding.xt.admin.service.impl;

import com.yacoding.xt.admin.domain.TopicDomain;
import com.yacoding.xt.admin.domain.repository.TopicDomainRepository;
import com.yacoding.xt.admin.model.TopicModel;
import com.yacoding.xt.admin.params.TopicParam;
import com.yacoding.xt.admin.service.TopicService;
import com.yacoding.xt.common.model.CallResult;
import com.yacoding.xt.common.service.AbstractTemplateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2022-06-30 上午 7:36
 */
@Service
public class TopicServiceImpl extends AbstractService implements TopicService {

    @Autowired
    private TopicDomainRepository topicDomainRepository;

    @Override
    public CallResult findTopicList(TopicParam topicParam) {
        TopicDomain topicDomain = this.topicDomainRepository.createDomain(topicParam);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return topicDomain.findTopicList();
            }
        });
    }

    @Override
    public TopicModel findTopicByTitle(String topicTitle) {
        TopicParam topicParam = new TopicParam();
        topicParam.setTopicTitle(topicTitle);
        TopicDomain topicDomain = this.topicDomainRepository.createDomain(topicParam);
        return topicDomain.findTopicByTitle();
    }

    @Override
    @Transactional
    public CallResult updateTopic(TopicParam topicParam) {
        TopicDomain topicDomain = this.topicDomainRepository.createDomain(topicParam);
        return this.serviceTemplate.execute(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return topicDomain.updateTopic();
            }
        });
    }

    @Override
    @Transactional
    public CallResult saveTopic(TopicParam topicParam) {
        TopicDomain topicDomain = this.topicDomainRepository.createDomain(topicParam);
        return this.serviceTemplate.execute(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return topicDomain.saveTopic();
            }
        });
    }
}