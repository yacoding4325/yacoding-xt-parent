package com.yacoding.xt.admin.service;

import com.yacoding.xt.admin.params.SubjectParam;
import com.yacoding.xt.common.model.CallResult;

/**
 * @Author yaCoding
 * @create 2022-06-24 下午 9:50
 */

public interface SubjectService {

    CallResult findSubjectList(SubjectParam subjectParam);

}
