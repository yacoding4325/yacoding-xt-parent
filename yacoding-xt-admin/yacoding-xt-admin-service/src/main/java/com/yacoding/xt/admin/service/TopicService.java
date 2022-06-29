package com.yacoding.xt.admin.service;

import com.yacoding.xt.admin.model.TopicModel;
import com.yacoding.xt.admin.params.TopicParam;
import com.yacoding.xt.common.model.CallResult;

/**
 * @Author yaCoding
 * @create 2022-06-30 上午 7:31
 */

public interface TopicService {

    /**
     * 根据条件 进行对应的题目 分页查询
     * @param topicParam
     * @return
     */
    CallResult findTopicList(TopicParam topicParam);

    TopicModel findTopicByTitle(String topicTitle);

    CallResult updateTopic(TopicParam topicParam);

    CallResult saveTopic(TopicParam topicParam);
}
