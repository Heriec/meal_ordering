package com.he.controller;

import com.he.pojo.Notice;
import com.he.service.NoticeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    @Qualifier("noticeService")
    private NoticeService noticeService;

    @RequestMapping("queryAll")
    public String queryAll(Model model) {
        List<Notice> notices = noticeService.queryAll();
        model.addAttribute("notices", notices);
        return "admin/notice";
    }

    @RequestMapping("queryById")
    public String queryById(Model model, @Param("id") Integer id) {
        Notice notice = noticeService.queryById(id);
        model.addAttribute("notice", notice);
        return "admin/notice_update";
    }

    @RequestMapping("update")
    public String update(Model model, @Param("id") Notice notice) {
        noticeService.updateNotice(notice);
        return queryAll(model);
    }

    @RequestMapping("insert")
    public String insert(Model model, @Param("name") String name, @Param("content") String content) {
        Integer id = (int) (System.currentTimeMillis() % 100);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String times = sdf.format(new Date());
        noticeService.insertNotice(new Notice(id, name, content, times));
        return queryAll(model);
    }

    @RequestMapping("delete")
    public String delete(Model model, @Param("id") Integer id) {
        this.noticeService.deleteNotice(id);
        return queryAll(model);
    }



    @RequestMapping("queryByIdtoQiantai")
    public String queryByIdtoQiantai(Model model,@Param("id") Integer id){
        Notice notice=noticeService.queryById(id);
        model.addAttribute("notice",notice);
        return "qiantai/notice";
    }
}
