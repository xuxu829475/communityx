package com.life.xu.communityx.controller;

import com.life.xu.communityx.dto.AccessTokenDTO;
import com.life.xu.communityx.dto.GithubUser;
import com.life.xu.communityx.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: communityx
 * @description: github授权登录
 * @author: Mr.Xu
 * @create: 2019-07-31 10:57
 **/
@Controller
public class AuthorizeController {

    @Autowired
    GitHubProvider gitHubProvider;
    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @RequestMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state,
                           HttpServletResponse response,
                           HttpServletRequest request,
                           HttpSession session){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = gitHubProvider.getUser(accessToken);
        if (githubUser != null) {
            //登录成功，写cookie 和session
            session.setAttribute("user",githubUser);
        }else {
            //登录失败，重新登录
        }
        return "index";
    }
}
