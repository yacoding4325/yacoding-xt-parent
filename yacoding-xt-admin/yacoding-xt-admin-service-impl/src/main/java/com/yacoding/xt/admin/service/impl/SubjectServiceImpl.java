package com.yacoding.xt.admin.service.impl;

import com.yacoding.xt.admin.domain.SubjectDomain;
import com.yacoding.xt.admin.domain.repository.SubjectDomainRepository;
import com.yacoding.xt.admin.params.SubjectParam;
import com.yacoding.xt.admin.service.SubjectService;
import com.yacoding.xt.common.model.CallResult;
import com.yacoding.xt.common.service.AbstractTemplateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;

/**
 * @Author yaCoding
 * @create 2022-06-24 下午 9:51
 */

@Service
@Transactional
public class SubjectServiceImpl extends AbstractService implements SubjectService {

    @Autowired
    private SubjectDomainRepository subjectDomainRepository;



    @Override
    public CallResult findSubjectList(SubjectParam subjectParam) {
        SubjectDomain subjectDomain = this.subjectDomainRepository.createDomain(subjectParam);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<ListModel>() {
            @Override
            public CallResult<ListModel> doAction() {
                return subjectDomain.findSubjectList();
            }
        });
    }
}
