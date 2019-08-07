package com.life.xu.communityx.model;

import lombok.Data;

/**
 * @program: communityx
 * @description: 问题
 * @author: Mr.Xu
 * @create: 2019-08-07 17:19
 **/
@Data
public class Question {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long creator;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
}
