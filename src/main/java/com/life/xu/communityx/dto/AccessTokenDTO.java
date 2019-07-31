package com.life.xu.communityx.dto;

import lombok.Data;

/**
 * @program: communityx
 * @description: access_token的DTO
 * @author: Mr.Xu
 * @create: 2019-07-31 11:17
 **/
@Data
public class AccessTokenDTO {

    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
