package com.life.xu.communityx.service.impl;

import com.life.xu.communityx.dao.UserDao;
import com.life.xu.communityx.model.User;
import com.life.xu.communityx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.text.normalizer.UnicodeSet;

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
        String accountId = user.getAccountId();
        User dbUser = findByAccountId(accountId);

        if(dbUser != null){
            dbUser.setGmtModified(System.currentTimeMillis());
            dbUser.setAvatarUrl(user.getAvatarUrl());
            dbUser.setName(user.getName());
            dbUser.setToken(user.getToken());
            userDao.updateUser(dbUser);
        }else {
            user.setGmtModified(System.currentTimeMillis());
            user.setGmtCreate(System.currentTimeMillis());
            userDao.insert(user);
        }
    }

    @Override
    public User findByToken(String token) {
        return userDao.findByToken(token);
    }
    @Override
    public User findByAccountId(String token) {
        return userDao.findByAccountId(token);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }
}
