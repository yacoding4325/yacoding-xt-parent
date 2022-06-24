package com.yacoding.xt.pojo;

import lombok.Data;

/**
 * @Author yaCoding
 * @create 2022-05-18 上午 10:55
 */

@Data
public class Subject {

    private Long id;

    private String subjectName;

    private String subjectGrade;

    private String subjectTerm;

    private Integer status;

}
