package com.yacoding.xt.admin.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yacoding.xt.admin.dao.SubjectMapper;
import com.yacoding.xt.admin.domain.SubjectDomain;
import com.yacoding.xt.admin.params.SubjectParam;
import com.yacoding.xt.pojo.Subject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author yaCoding
 * @create 2022-06-24 下午 9:54
 */

@Component
public class SubjectDomainRepository {

    @Resource
    private SubjectMapper subjectMapper;

    public SubjectDomain createDomain(SubjectParam subjectParam) {
        return  new SubjectDomain(subjectParam, this);
    }

    public Page<Subject> findSubjectList(Integer currentPage,Integer pageSize) {
        Page<Subject> page = new Page<>(currentPage, pageSize);
        return subjectMapper.selectPage(page, new LambdaQueryWrapper<>());
    }

}
