package com.yacoding.xt.pojo;

import lombok.Data;

/**
 * @Author yaCoding
 * @create 2022-06-30 上午 6:59
 */

/**
 * 数据库的属性对应
 */
@Data
public class CourseSubject {

    private Long id;

    private Long courseId;

    private Long subjectId;

}
