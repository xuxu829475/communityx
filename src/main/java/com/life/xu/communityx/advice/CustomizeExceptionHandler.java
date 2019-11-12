package com.life.xu.communityx.advice;

import com.life.xu.communityx.exception.CustomizeErrorCode;
import com.life.xu.communityx.exception.CustomizeException;
import com.life.xu.communityx.util.ResultVOUtil;
import com.life.xu.communityx.vo.ResultVO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: communityx
 * @description: 异常处理
 * @author: Mr.Xu
 * @create: 2019-10-22 10:25
 **/
@ControllerAdvice
public class CustomizeExceptionHandler {
    /*@ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e, Model model) {
        if (e instanceof CustomizeException) {
            model.addAttribute("message", e.getMessage());
        } else {
            model.addAttribute("message", CustomizeErrorCode.SYS_ERROR.getMessage());
        }
        return new ModelAndView("error");
    }*/

    @ExceptionHandler(CustomizeException.class)
    public String handleException(Exception e,HttpServletRequest request){
        request.setAttribute("javax.servlet.error.status_code",400);
        CustomizeException exception = (CustomizeException) e;
        ResultVOUtil.error(exception.getCode(),e.getMessage());
        return "forward:/error";
    }
}
