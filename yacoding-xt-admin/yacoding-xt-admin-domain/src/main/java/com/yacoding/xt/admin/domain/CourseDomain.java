package com.yacoding.xt.admin.domain;

import com.yacoding.xt.admin.domain.repository.CourseDomainRepository;
import com.yacoding.xt.admin.model.CourseModel;
import com.yacoding.xt.admin.params.CourseParam;
import com.yacoding.xt.common.model.CallResult;
import com.yacoding.xt.pojo.Course;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @Author yaCoding
 * @create 2022-06-30 上午 7:11
 */

public class CourseDomain {

    private CourseParam courseParam;

    private CourseDomainRepository courseDomainRepository;

    public CourseDomain(CourseParam courseParam, CourseDomainRepository courseDomainRepository) {

        this.courseParam = courseParam;
        this.courseDomainRepository = courseDomainRepository;
    }

    private CourseModel copy(Course course) {
        CourseModel courseModel = new CourseModel();
        BeanUtils.copyProperties(course, courseModel);
        courseModel.setId(course.getId().toString());
        return courseModel;
    }

    private List<CourseModel> copyList(List<Course> courseList) {
        return null;
    }

    public CallResult<Object> saveCourse() {
        return null;
    }

    public CallResult<Object> updateCourse() {
        return null;
    }

    public CallResult<Object> findPage() {
        return null;
    }

    public CallResult<Object> findCourseById() {
        return null;
    }
}
