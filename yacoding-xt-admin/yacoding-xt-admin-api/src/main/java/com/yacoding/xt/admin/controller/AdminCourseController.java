package com.yacoding.xt.admin.controller;

import com.yacoding.xt.admin.params.CourseParam;
import com.yacoding.xt.admin.service.CourseService;
import com.yacoding.xt.common.model.CallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2022-07-02 下午 2:33
 */
@RestController
@RequestMapping("course")
public class AdminCourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "saveCourse")
    public CallResult saveCourse(@RequestBody CourseParam courseParam){
        return courseService.saveCourse(courseParam);
    }

    @RequestMapping(value = "updateCourse")
    public CallResult updateCourse(@RequestBody CourseParam courseParam){
        return courseService.updateCourse(courseParam);
    }

    @RequestMapping(value = "findCourseById")
    public CallResult findSubjectById(@RequestBody CourseParam courseParam){
        return courseService.findCourseById(courseParam);
    }


    @RequestMapping(value = "findPage")
    public CallResult findPage(@RequestBody CourseParam courseParam){
        return courseService.findPage(courseParam);
    }

    /**
     * 课程科目学习 学习单元
     * @param courseParam
     * @return
     */
    @RequestMapping("subjectInfo")
    public CallResult subjectInfo(@RequestBody CourseParam courseParam) {
        return courseService.subjectInfo(courseParam);
    }

}
