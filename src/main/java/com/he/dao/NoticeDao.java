package com.he.dao;

import com.he.pojo.Notice;

import java.util.List;

public interface NoticeDao {
    Notice queryById(Integer id);

    List<Notice> queryAll();

    int insertNotice(Notice notice);

    int updateNotice(Notice notice);

    int deleteNotice(Integer id);
}
