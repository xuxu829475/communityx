package com.life.xu.communityx.vo;

import lombok.Data;

/**
 * @program: supplySAAS_org
 * @description: http请求最外层对象
 * @author: Mr.Xu
 * @create: 2019-07-25 14:57
 **/
@Data
public class ResultVO<T> {
    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
