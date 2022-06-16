package com.yacoding.xt.admin.service;

import com.yacoding.xt.common.model.CallResult;

/**
 * @Author yaCoding
 * @create 2022-05-18 上午 11:00
 */

public interface CourseService {

    CallResult saveCourse(CourseParam courseParam);

    CallResult updateCourse(CourseParam courseParam);

    CallResult findCourseById(CourseParam courseParam);

    CallResult findPage(CourseParam courseParam);

}
