package com.yacoding.xt.common.service;

import com.yacoding.xt.common.model.CallResult;

/**
 * @Author yaCoding
 * @create 2022/4/4 下午 5:56
 */

public interface TemplateAction<T> {//归还化操作
    //第一步 检查参数
    CallResult<T> checkParam();

    //第二步 检查业务逻辑是否符合需求
    CallResult<T> checkBiz();

    //第三步 执行
    CallResult<T> doAction();

    //第四步 执行完成之后 要进行的操作
    void finishUp(CallResult<T> callResult);

}
