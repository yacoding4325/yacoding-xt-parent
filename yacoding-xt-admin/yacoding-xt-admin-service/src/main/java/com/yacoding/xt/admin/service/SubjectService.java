package com.yacoding.xt.admin.service;

import com.yacoding.xt.admin.params.SubjectParam;
import com.yacoding.xt.common.model.CallResult;

/**
 * @Author yaCoding
 * @create 2022-06-24 下午 9:50
 */

public interface SubjectService {
    /**
     * 分页查询
     * @param subjectParam
     * @return
     */
    CallResult findSubjectList(SubjectParam subjectParam);

    /**
     * 新增学科
     * @param subjectParam
     * @return
     */
    CallResult saveSubject(SubjectParam subjectParam);

    /**
     * 根据id查询subject
     * @param subjectParam
     * @return
     */
    CallResult findSubjectById(SubjectParam subjectParam);

    /**
     * 编辑学科信息
     * @param subjectParam
     * @return
     */
    CallResult updateSubject(SubjectParam subjectParam);

    /**
     * 查询所有的学科信息
     * @param subjectParam
     * @return
     */
    CallResult allSubjectList(SubjectParam subjectParam);
}

