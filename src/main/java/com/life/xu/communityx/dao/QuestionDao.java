package com.life.xu.communityx.dao;

import com.life.xu.communityx.model.Question;
import com.life.xu.communityx.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

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

    @Select("select * from question")
    List<Question> findAll();

    List<Question> findPage(@Param("parMap") Map<String, Object> parMap, @Param("offPage") Integer offPage, @Param("pageSize") Integer pageSize);

    Integer findCount(Map<String, Object> parMap);

    @Update("update question set title=#{title},description=#{description},gmt_create=#{gmtCreate},gmt_modified=#{gmtModified},creator=#{creator},comment_count=#{commentCount},view_count=#{viewCount},like_count=#{likeCount},tag=#{tag} where id = #{id}")
    void update(Question question);
}
