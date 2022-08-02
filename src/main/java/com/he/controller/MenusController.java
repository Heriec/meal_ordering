package com.he.controller;

import com.he.pojo.Admin;
import com.he.pojo.Menus;
import com.he.pojo.Notice;
import com.he.pojo.Types;
import com.he.service.MenusService;
import com.he.service.NoticeService;
import com.he.service.TypesService;
import com.he.util.AlipayUtil;
import com.he.util.Constants;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("menus")
public class MenusController {

    @Resource(name = "menusService")
    private MenusService menusService;

    @Resource(name = "noticeService")
    private NoticeService noticeService;

    @Resource(name = "typesService")
    private TypesService typesService;

    @RequestMapping("/toAddPage")
    public String toAddPage(Model model) {
        List<Types> types = typesService.queryAll();
        model.addAttribute("typesList", types);
        return "/admin/menus_add";
    }

    @RequestMapping("/add")
    public String insert(Menus menus, @RequestParam("img") MultipartFile multipartFile, HttpSession session) throws IOException {
        String realPath = session.getServletContext().getRealPath("");
        if (!multipartFile.isEmpty()) {
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File(realPath + "public\\img\\" + originalFilename));
            menus.setImgpath("img/" + originalFilename);
        }
        menus.setSums(0);
        menus.setSums1(0);
        System.out.println(menus);
        menusService.insertMenus(menus);

        return "/admin/menus_add";
    }

    @RequestMapping("allMenus")
    public String menusList(Model model) {
        List<Types> typesList = typesService.queryAll();
        model.addAttribute("typesList", typesList);
        List<Menus> list = menusService.queryAllMenus();
        model.addAttribute("list", list);
        return "/admin/menus";
    }

    //  跳转至修改页面
    @RequestMapping("/toUpdatePage")
    public String toUpdatePage(Integer id, Model model) {
        Menus menus = menusService.queryById(id);
        model.addAttribute("menu", menus);
        List<Types> typesList = typesService.queryAll();
        model.addAttribute("typesList", typesList);
        return "/admin/menus_update";
    }

    @RequestMapping("update")
    public void update(Menus menus, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        menusService.updateMenus(menus);
        request.getRequestDispatcher("../menus/allMenus").forward(request, response);
    }

    //菜单信息删除
    @RequestMapping("/delete")
    public void delete(Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        menusService.deleteById(id);
        request.getRequestDispatcher("../menus/allMenus").forward(request, response);
    }


    //    qiantai处理
    @RequestMapping("/qiantai/allMenus")
    public String qiantaimenusList(Model model) {
        List<Menus> list = menusService.queryAllMenus();
        int sum = 0;
        Menus tmp = null;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i).getSums1() < list.get(j).getSums1()) {
                    Collections.swap(list, i, j);
                }
            }
        }
        model.addAttribute("list", list);
        List<Types> typesList = typesService.queryAll();
        model.addAttribute("typesLIst", typesList);
        List<Notice> notices = noticeService.queryAll();
        model.addAttribute("notice", notices);
        return "/qiantai/index";
    }

    @RequestMapping("qiantai/queryMenusById")
    public String queryById(Model model, @Param("id") Integer id) {
        Menus menus = menusService.queryById(id);
        model.addAttribute("menus", menus);
        return "qiantai/show";
    }
}
