package com.yacoding.xt.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yacoding.xt.pojo.Subject;

import java.util.List;

/**
 * @Author yaCoding
 * @create 2022-05-18 上午 10:56
 */

public interface SubjectMapper extends BaseMapper<Subject> {

    List<Subject> findSubjectListByCourseId(Long courseId);

}
