package com.life.xu.communityx.vo;

import lombok.Data;

/**
 * @program: communityx
 * @description: 回复VO
 * @author: Mr.Xu
 * @create: 2019-10-22 14:11
 **/
@Data
public class CommentVO {
    private Long parentId;
    private String content;
    private Integer type;
}
