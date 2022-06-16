package com.yacoding.xt.sso.model;

import lombok.Data;


/**
 * @Author yaCoding
 * @create 2022-04-23 下午 11:06
 */

@Data
public class UserModel {

    private String nickname;

    private Integer sex;

    private String city;

    private String province;

    private String country;

    private String headImageUrl;

    private String mobile;

    private String name;

    private String inviteUrl;

    private String school;

    private String area;

    private String grade;

//    private List<BillModel> billModels;
}
