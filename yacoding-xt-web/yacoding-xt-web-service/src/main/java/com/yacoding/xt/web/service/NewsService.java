package com.yacoding.xt.web.service;

import com.yacoding.xt.common.model.CallResult;
import com.yacoding.xt.web.model.params.NewsParam;

/**
 * @Author yaCoding
 * @create 2022-05-08 下午 3:16
 */

public interface NewsService {
    /**
     * 分页查询 新闻列表
     * @param newsParam
     * @return
     */
    CallResult newsList(NewsParam newsParam);

    CallResult findNewsById(NewsParam newsParam);
}

