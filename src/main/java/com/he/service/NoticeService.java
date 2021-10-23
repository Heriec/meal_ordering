package com.he.service;

import com.he.pojo.Notice;

import java.util.List;

public interface NoticeService {
    Notice queryById(Integer id);

    List<Notice> queryAll();

    int insertNotice(Notice notice);

    Notice updateNotice(Notice notice);

    boolean deleteNotice(Integer id);
}
