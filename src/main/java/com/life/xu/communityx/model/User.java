package com.life.xu.communityx.model;

import lombok.Data;

/**
 * @program: communityx
 * @description: 用户表
 * @author: Mr.Xu
 * @create: 2019-08-01 17:24
 **/
@Data
public class User {

    private Long id;

    private String accountId;

    private String name;

    private String token;

    private String avatarUrl;

    private Long gmtCreate;

    private Long gmtModified;
}
