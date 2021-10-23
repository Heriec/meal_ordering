package com.he.controller;


import com.he.pojo.Admin;
import com.he.service.AdminService;
import com.he.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    @Qualifier("adminService")
    private AdminService adminService;

    @RequestMapping("login")
    public String toLogin() {
        return "/admin/index";
    }


    @PostMapping("login")
    public String login(Admin admin, HttpServletRequest request, HttpSession session) {
        admin = adminService.login(admin.getName(), admin.getPwd());
        System.out.println("admin=>"+admin);
        if (admin != null) {
            request.setAttribute("admin", admin);
            session.setAttribute(Constants.ADMIN_SESSION, admin);
            return "redirect:/admin/toMain";
        } else {
            request.setAttribute(Constants.MESSAGE, "用户名密码错误");
            return "/admin/index";
        }
    }
    @GetMapping("toMain")
    public String tomain(){
        return "/admin/main";
    }

    @RequestMapping("update")
    public String update(Admin admin) {
        adminService.updateAdmin(admin);
        System.out.println(admin);
        return "/admin/menus";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute(Constants.ADMIN_SESSION);
        return "redirect:/admin/login";
    }
}
