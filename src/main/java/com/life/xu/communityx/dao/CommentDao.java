package com.life.xu.communityx.dao;

import com.life.xu.communityx.model.Comment;
import com.life.xu.communityx.model.CommentQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentDao {
    int countByExample(CommentQuery example);

    int deleteByExample(CommentQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentQuery example);

    Comment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentQuery example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentQuery example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}