package com.yacoding.xt.admin.domain;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yacoding.xt.admin.domain.repository.SubjectDomainRepository;
import com.yacoding.xt.admin.params.SubjectParam;
import com.yacoding.xt.common.model.CallResult;
import com.yacoding.xt.pojo.Subject;

import javax.swing.*;
import java.util.List;

/**
 * @Author yaCoding
 * @create 2022-06-24 下午 9:57
 */

public class SubjectDomain {

    private SubjectParam subjectParam;
    private SubjectDomainRepository subjectDomainRepository;

    public SubjectDomain(SubjectParam subjectParam, SubjectDomainRepository subjectDomainRepository) {
        this.subjectDomainRepository = subjectDomainRepository;
        this.subjectParam = subjectParam;
    }

    public CallResult<ListModel> findSubjectList() {
        Page<Subject> subjectList = this.subjectDomainRepository
                .findSubjectList(
                        this.subjectParam.getPage(),
                        this.subjectParam.getPageSize()
                );
//        ListModel listModel = new ListModel();
//        listModel.setTotal((int) subjectList.getTotal());
//        List<Subject> result = subjectList.getRecords();
//        for (Subject subject : result) {
//            subject.setSubjectName(subject.getSubjectName() +" " + subject.getSubjectGrade() + " " +subject.getSubjectTerm());
//        }
//        listModel.setList(result);
        return CallResult.success();
    }

    public CallResult<Object> checkSaveSubjectParam() {
        return null;
    }

    public CallResult<Object> checkSaveSubjectBiz() {
        return null;
    }

    public CallResult<Object> saveSubject() {
        return null;
    }

    public CallResult<Object> findSubjectById() {
        return null;
    }

    public CallResult<Object> updateSubject() {
        return null;
    }

    public CallResult<Object> allSubjectList() {
        return null;
    }
}
