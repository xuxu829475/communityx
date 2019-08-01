package com.life.xu.communityx.service.impl;

import com.life.xu.communityx.dao.UserDao;
import com.life.xu.communityx.model.User;
import com.life.xu.communityx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: communityx
 * @description: 用户接口实现
 * @author: Mr.Xu
 * @create: 2019-08-01 17:37
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void createOrUpdate(User user) {
        userDao.insert(user);
    }
}
