package com.he.service.impl;

import com.he.dao.NoticeDao;
import com.he.pojo.Notice;
import com.he.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeDao noticeDao;
    @Override
    public Notice queryById(Integer id) {
        return noticeDao.queryById(id);
    }

    @Override
    public List<Notice> queryAll() {
        return noticeDao.queryAll();
    }

    @Override
    public int insertNotice(Notice notice) {
        return noticeDao.insertNotice(notice);
    }

    @Override
    public Notice updateNotice(Notice notice) {
        noticeDao.updateNotice(notice);
        return this.queryById(notice.getId());
    }

    @Override
    public boolean deleteNotice(Integer id) {
        return (noticeDao.deleteNotice(id)>0);
    }
}
