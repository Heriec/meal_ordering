package com.he.interceptor;

import com.he.pojo.Users;
import com.he.util.Constants;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception{
        String uri=request.getRequestURI();
        if(uri.contains("users/login")){
            return true;
        }
        if(!uri.contains("/qiantai")){
            HttpSession session=request.getSession();
            Users user=(Users)session.getAttribute(Constants.USER_SESSION);
            if(user!=null)
                return true;
            request.setAttribute("msg","您还没有登录，请先登录");
            request.getRequestDispatcher("/public/qiantai/login.jsp").forward(request,response);
            return false;
        }
        return true;

    }
}
