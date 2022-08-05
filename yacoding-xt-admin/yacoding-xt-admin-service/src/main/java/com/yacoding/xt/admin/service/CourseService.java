package com.yacoding.xt.admin.service;

import com.yacoding.xt.admin.params.CourseParam;
import com.yacoding.xt.common.model.CallResult;

/**
 * @Author yaCoding
 * @create 2022-06-30 上午 7:31
 */

public interface CourseService {

    CallResult saveCourse(CourseParam courseParam);

    CallResult updateCourse(CourseParam courseParam);

    CallResult findCourseById(CourseParam courseParam);

    CallResult findPage(CourseParam courseParam);

    CallResult subjectInfo(CourseParam courseParam);
}
