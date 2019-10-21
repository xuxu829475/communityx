package com.life.xu.communityx.service.impl;

import com.life.xu.communityx.dao.UserDao;
import com.life.xu.communityx.model.User;
import com.life.xu.communityx.model.UserQuery;
import com.life.xu.communityx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            userDao.updateByPrimaryKeySelective(dbUser);
        }else {
            user.setGmtModified(System.currentTimeMillis());
            user.setGmtCreate(System.currentTimeMillis());
            userDao.insertSelective(user);
        }
    }

    @Override
    public User findByToken(String token) {
        User user = null;
        UserQuery userQuery = new UserQuery();
        UserQuery.Criteria userQueryCriteria = userQuery.createCriteria();
        userQueryCriteria.andTokenEqualTo(token);
        List<User> userList = userDao.selectByExample(userQuery);
        if (userList.size() != 0) {
            user = userList.get(0);
        }
        return user;
    }
    @Override
    public User findByAccountId(String accountId) {
        User user = null;
        UserQuery userQuery = new UserQuery();
        UserQuery.Criteria userQueryCriteria = userQuery.createCriteria();
        userQueryCriteria.andAccountIdEqualTo(accountId);
        List<User> userList = userDao.selectByExample(userQuery);
        if (userList.size() != 0) {
            user = userList.get(0);
        }
        return user;
    }

    @Override
    public User findById(Long id) {
        return userDao.selectByPrimaryKey(id);
    }
}
