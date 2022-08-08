package com.yacoding.xt.admin.domain;

import com.yacoding.xt.admin.domain.repository.CourseDomainRepository;
import com.yacoding.xt.admin.model.CourseModel;
import com.yacoding.xt.admin.model.SubjectModel;
import com.yacoding.xt.admin.params.CourseParam;
import com.yacoding.xt.common.login.UserThreadLocal;
import com.yacoding.xt.common.model.BusinessCodeEnum;
import com.yacoding.xt.common.model.CallResult;
import com.yacoding.xt.pojo.Course;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
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

    public CallResult<Object> subjectInfo() {
        Long userId = UserThreadLocal.get();

        Long courseId = this.courseParam.getCourseId();
        Course course = this.courseDomainRepository.findCourseById(courseId);
        if (course == null){
            return CallResult.fail(BusinessCodeEnum.TOPIC_PARAM_ERROR.getCode(),"参数错误");
        }
        List<SubjectModel> subjectList = this.courseDomainRepository.createSubjectDomain(null).findSubjectModelListByCourseId(courseId);
        List<SubjectViewModel> subjectModelList = new ArrayList<>();
        for (SubjectModel subject : subjectList){
            List<Integer> subjectUnitList = this.courseDomainRepository.createSubjectDomain(null).findSubjectUnit(subject.getId());
            SubjectViewModel subjectViewModel = new SubjectViewModel();
            subjectViewModel.setId(subject.getId());
            subjectViewModel.setSubjectName(subject.getSubjectName()+" "+subject.getSubjectGrade()+" "+subject.getSubjectTerm());
            subjectViewModel.setSubjectGrade(subject.getSubjectGrade());
            subjectViewModel.setSubjectTerm(subject.getSubjectTerm());
            subjectViewModel.setSubjectUnitList(subjectUnitList);

//            if (userId != null){
//                UserHistory userHistory = this.courseDomainRepository.createTopicDomain(null).findUserHistory(userId, subject.getId(), HistoryStatus.NO_FINISH.getCode());
//                if (userHistory != null) {
//                    String subjectUnits = userHistory.getSubjectUnits();
//                    if (StringUtils.isNotEmpty(subjectUnits)) {
//                        List<Integer> strings = JSON.parseArray(subjectUnits, Integer.class);
//                        subjectViewModel.setSubjectUnitSelectedList(strings);
//                    }
//                }
//            }
            subjectModelList.add(subjectViewModel);
        }
        return CallResult.success(subjectModelList);
    }
}
