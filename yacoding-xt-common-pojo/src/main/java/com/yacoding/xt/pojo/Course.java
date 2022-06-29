package com.yacoding.xt.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author yaCoding
 * @create 2022-06-30 上午 6:55
 */

@Data
public class Course {
    private Long id;
    private String courseName;
    private String courseDesc;
    private String subjects;
    private BigDecimal coursePrice;
    private BigDecimal courseZhePrice;
    private Integer orderTime;//天数
    private Integer courseStatus;//正常，下架
    private String imageUrl;
}
