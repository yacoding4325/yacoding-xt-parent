package com.yacoding.xt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Author yaCoding
 * @create 2022-06-24 下午 9:34
 */

@Data
public class SubjectUnit {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long subjectId;
    private Integer subjectUnit;
}
