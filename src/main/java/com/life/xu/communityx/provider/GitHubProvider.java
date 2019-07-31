package com.life.xu.communityx.provider;

import com.alibaba.fastjson.JSON;
import com.life.xu.communityx.dto.AccessTokenDTO;
import com.life.xu.communityx.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @program: communityx
 * @description: gitbub的服务提供
 * @author: Mr.Xu
 * @create: 2019-07-31 11:16
 **/
@Component
public class GitHubProvider {

    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, com.alibaba.fastjson.JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String retStr = response.body().string();
            String token = retStr.split("&")[0].split("=")[1];
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser user = JSON.parseObject(string, GithubUser.class);
            return user;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
