package com.yacoding.xt.common.service;

import com.yacoding.xt.common.model.CallResult;

/**
 * @Author yaCoding
 * @create 2022/4/4 下午 5:55
 */

public abstract class AbstractTemplateAction <T> implements TemplateAction<T>{

    @Override
    public CallResult<T> checkParam() {
        return CallResult.success();
    }

    @Override
    public CallResult<T> checkBiz() {
        return CallResult.success();
    }

    @Override
    public void finishUp(CallResult<T> callResult) {

    }

}
