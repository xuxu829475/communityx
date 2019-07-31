package com.life.xu.communityx.dto;

import lombok.Data;

/**
 * @program: communityx
 * @description: github返回用户信息
 * @author: Mr.Xu
 * @create: 2019-07-31 13:23
 **/
@Data
public class GithubUser {
    private String login;
    private Long id;
    private String bio;
}
