package com.life.xu.communityx.interceptor;

import com.life.xu.communityx.model.User;
import com.life.xu.communityx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: communityx
 * @description: 登录拦截
 * @author: Mr.Xu
 * @create: 2019-09-04 16:12
 **/
@Service
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if("token".equals(cookie.getName())){
                    String token = cookie.getValue();
                    user = userService.findByToken(token);
                }
            }
        }
        if(user == null){
            //跳转列表页
            response.sendRedirect("/");
            return false;
        }else {
            request.getSession().setAttribute("user",user);
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
