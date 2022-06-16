package com.yacoding.xt.common.service;

import com.yacoding.xt.common.model.BusinessCodeEnum;
import com.yacoding.xt.common.model.CallResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @Author yaCoding
 * @create 2022/4/4 下午 6:02
 */

@Component
@Slf4j
public class ServiceTemplateImpl implements ServiceTemplate{
    @Override
    public <T> CallResult<T> execute(TemplateAction<T> action) {
        try{
            CallResult<T> callResult = action.checkParam();//检查参数执行
            if(callResult==null){
                log.warn("execute: Null result while checkParam");
                return CallResult.fail(BusinessCodeEnum.CHECK_PARAM_NO_RESULT.getCode(), BusinessCodeEnum.CHECK_PARAM_NO_RESULT.getMsg());
            }
            if(!callResult.isSuccess()){
                return callResult;//返回成功
            }
            callResult = action.checkBiz();//检查有业务操作
            if(callResult==null){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//回滚操作
                log.warn("execute: Null result while checkBiz");
                return CallResult.fail(BusinessCodeEnum.CHECK_BIZ_NO_RESULT.getCode(), BusinessCodeEnum.CHECK_BIZ_NO_RESULT.getMsg());
            }
            if(!callResult.isSuccess()){//成功
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return callResult;
            }
            long start = System.currentTimeMillis();//业务开始时间
            CallResult<T> cr= action.doAction();
            log.info("execute datasource method run time:{}ms", System.currentTimeMillis() - start);
            if (cr == null){//回滚，
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return CallResult.fail(BusinessCodeEnum.CHECK_ACTION_NO_RESULT.getCode(), BusinessCodeEnum.CHECK_ACTION_NO_RESULT.getMsg());
            }
            if (!cr.isSuccess()){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//不成功回滚操作
                return cr;
            }
            if(cr.isSuccess()){
                action.finishUp(cr);
            }
            return cr;
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//异常处理
            e.printStackTrace();
            log.error("excute error", e);
            return CallResult.fail();
        }
    }

    @Override
    public <T> CallResult<T> executeQuery(TemplateAction<T> action) {//
        try {
            CallResult<T> callResult = action.checkParam();
            if (callResult == null) {
                log.warn("executeQuery: Null result while checkParam");
                return CallResult.fail(BusinessCodeEnum.CHECK_PARAM_NO_RESULT.getCode(), BusinessCodeEnum.CHECK_PARAM_NO_RESULT.getMsg());
            }
            if (!callResult.isSuccess()) {
                return callResult;
            }
            callResult = action.checkBiz();
            if (callResult == null) {
                log.warn("executeQuery: Null result while checkBiz");
                return CallResult.fail(BusinessCodeEnum.CHECK_BIZ_NO_RESULT.getCode(), BusinessCodeEnum.CHECK_BIZ_NO_RESULT.getMsg());
            }
            if (!callResult.isSuccess()) {
                return callResult;
            }
            long start = System.currentTimeMillis();
            CallResult<T> cr = action.doAction();
            log.info("executeQuery datasource method run time:{}ms", System.currentTimeMillis() - start);
            if (cr == null) {
                return CallResult.fail(BusinessCodeEnum.CHECK_ACTION_NO_RESULT.getCode(), BusinessCodeEnum.CHECK_ACTION_NO_RESULT.getMsg());
            }
            if (!cr.isSuccess()) {
                return cr;
            }
            if (cr.isSuccess()) {
                action.finishUp(cr);
            }
            return cr;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("executeQuery error", e);
            return CallResult.fail();
        }
    }
}