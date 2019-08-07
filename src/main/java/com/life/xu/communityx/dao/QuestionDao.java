package com.life.xu.communityx.dao;

import com.life.xu.communityx.model.Question;
import com.life.xu.communityx.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @program: communityx
 * @description: 问题DAO
 * @author: Mr.Xu
 * @create: 2019-08-07 17:22
 **/
@Mapper
public interface QuestionDao {

    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,comment_count,view_count,like_count,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{commentCount},#{viewCount},#{likeCount},#{tag})")
    int insert(Question question);

    @Select("select * from question where id = #{id}")
    Question findById(@Param("id") Long id);
}
