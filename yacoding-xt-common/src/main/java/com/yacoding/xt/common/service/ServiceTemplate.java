package com.yacoding.xt.common.service;

import com.yacoding.xt.common.model.CallResult;

/**
 * @Author yaCoding
 * @create 2022/4/4 下午 6:02
 */
//业务增删改查
public interface ServiceTemplate {
    /**
     * run in  datasource and execute Transaction
     * @param action
     * @param <T>
     * @return
     */
    <T> CallResult<T> execute(TemplateAction<T> action);

    /**
     * run in  datasource and not execute Transaction
     * @param action
     * @param <T>
     * @return
     */
    <T> CallResult<T> executeQuery(TemplateAction<T> action);
}
