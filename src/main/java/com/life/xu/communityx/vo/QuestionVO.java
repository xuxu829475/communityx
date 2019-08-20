package com.life.xu.communityx.vo;

import com.life.xu.communityx.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: communityx
 * @description: 问题VO
 * @author: Mr.Xu
 * @create: 2019-08-09 13:29
 **/
@Getter
@Setter
@ToString
public class QuestionVO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long creator;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer commentCount=0;
    private Integer viewCount=0;
    private Integer likeCount=0;
    private User user;
}
