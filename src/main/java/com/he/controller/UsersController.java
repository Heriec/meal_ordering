package com.he.controller;

import com.he.pojo.Users;
import com.he.service.UsersService;
import com.he.util.Constants;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RequestMapping("users")
@Controller
public class UsersController {
    @Resource(name = "usersService")
    private UsersService usersService;

    @RequestMapping("login")
    public String login(String name, String pwd, HttpSession session) {
        Users user = usersService.login(name, pwd);
        if (user != null) {
            session.setAttribute(Constants.USER_SESSION, user);
            return "redirect:/menus/qiantai/allMenus";
        } else {
            session.setAttribute("message", "用户名密码错误");
            return "qiantai/userLoginFail";
        }
    }
    @RequestMapping("insert")
    public String insert(Users user){
        usersService.insertUser(user);
        return "redirect:../public/qiantai/login.jsp";
    }
    @RequestMapping("toUpdate")
    public String toUpdate(){
        return "/qiantai/center";
    }

    @RequestMapping("update")
    public String update(HttpSession session,Users users){
        System.out.println(users);
        usersService.updateUser(users);
        session.removeAttribute(Constants.USER_SESSION);
        return "redirect:../public/qiantai/login.jsp";
    }
    @RequestMapping("logout")
    public String logout(HttpSession session){
        //清除session
        if (session.getAttribute(Constants.USER_SESSION)!=null) {
            session.removeAttribute(Constants.USER_SESSION);
        }
            return "redirect:/qiantai";
    }
}
