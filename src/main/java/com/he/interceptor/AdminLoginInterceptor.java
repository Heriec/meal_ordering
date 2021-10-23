package com.he.interceptor;

import com.he.pojo.Admin;
import com.he.pojo.Users;
import com.he.util.Constants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUI = request.getRequestURI();
        System.out.println(requestUI);
        if (requestUI.contains("gologin")){
            return true;
        }
        if (requestUI.contains("login")){
            return true;
        }
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute(Constants.ADMIN_SESSION);
        System.out.println(111);
        System.out.println("Admin=>"+admin);
        //判断session中是否有用户数据，如果有，则返回true，继续向下执行
        if (admin != null) {
            return true;
        }
        System.out.println(111);
        request.setAttribute("msg", "您还没有登录，请先登录！");
        request.getRequestDispatcher("/public/admin/index.jsp").forward(request, response);
        return false;
    }

}
