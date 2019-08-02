package com.life.xu.communityx.dao;

import com.life.xu.communityx.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @program: communityx
 * @description: 用户DAO
 * @author: Mr.Xu
 * @create: 2019-08-01 17:29
 **/
@Mapper
public interface UserDao {

    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified})")
    int insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}
