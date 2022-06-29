package com.yacoding.xt.pojo;

import lombok.Data;

/**
 * @Author yaCoding
 * @create 2022-06-30 上午 7:02
 */

@Data
public class UserCourse {

    private Long id;

    private Long userId;

    private Long courseId;

    private Long createTime;

    private Long expireTime;

    private Integer studyCount;

}
