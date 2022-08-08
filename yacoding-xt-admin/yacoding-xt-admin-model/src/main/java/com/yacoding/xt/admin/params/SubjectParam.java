package com.yacoding.xt.admin.params;

import com.yacoding.xt.admin.model.SubjectModel;
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
    private List<Integer> subjectUnits;

    private Integer status;

    private int currentPage = 1;
    private int pageSize = 20;

    private String queryString;
}
