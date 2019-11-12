package com.life.xu.communityx.controller;

import com.life.xu.communityx.model.Comment;
import com.life.xu.communityx.util.ResultVOUtil;
import com.life.xu.communityx.vo.CommentVO;
import com.life.xu.communityx.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: communityx
 * @description: 回复controller
 * @author: Mr.Xu
 * @create: 2019-10-22 14:12
 **/
@Controller
public class CommentController {

    /*@Autowired
    CommentService*/

    @ResponseBody
    @PostMapping("/comment")
    public ResultVO comment(@RequestBody CommentVO commentVO){
        Comment comment = new Comment();
        comment.setParentId(commentVO.getParentId());
        comment.setContent(commentVO.getContent());
        comment.setType(commentVO.getType());
        comment.setLikeCount(0L);
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setCommentator(1L);

        return ResultVOUtil.success();
    }

}
