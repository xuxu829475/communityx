package com.life.xu.communityx.dao;

import com.life.xu.communityx.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @program: communityx
 * @description: 用户DAO
 * @author: Mr.Xu
 * @create: 2019-08-01 17:29
 **/
@Mapper
public interface UserDao {

    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified,avatar_url) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    int insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(Long id);

    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("updata user set name=#{name},token=#{token},gmt_create=#{gmtCreate},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl} where id=#{id}")
    void updateUser(User user);
}
