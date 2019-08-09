package com.life.xu.communityx.service;

import com.life.xu.communityx.model.User;

/**
 * @program: communityx
 * @description: 用户接口
 * @author: Mr.Xu
 * @create: 2019-08-01 17:35
 **/
public interface UserService {

    void createOrUpdate(User user);

    User findByToken(String token);

    User findById(Long id);
}
