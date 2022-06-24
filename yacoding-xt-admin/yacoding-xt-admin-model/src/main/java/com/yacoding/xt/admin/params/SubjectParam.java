package com.yacoding.xt.admin.params;

import lombok.Data;

import java.util.List;

/**
 * @Author yaCoding
 * @create 2022-06-24 下午 9:43
 */
@Data
public class SubjectParam {

    private Long id;

    private String subjectName;

    private String subjectGrade;

    private String subjectTerm;

    private List<Integer> subjectUnit;

    private Integer status;

    private int Page = 1;

    private int pageSize = 20;

//    public Integer getPage() {
//        return null;
//    }
}