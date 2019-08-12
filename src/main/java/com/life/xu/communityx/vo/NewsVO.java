package com.life.xu.communityx.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @program: communityx
 * @description: 新闻
 * @author: Mr.Xu
 * @create: 2019-08-07 15:50
 **/
@Data
@Accessors(chain = true)
public class NewsVO {
    private Long id;
    private String title;
    private Date add_time;
    private String zhaiyao;
    private Long click;
    private String img_url;
    private String content;
}
