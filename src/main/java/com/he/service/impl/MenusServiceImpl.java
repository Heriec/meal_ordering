package com.he.service.impl;

import com.he.dao.MenusDao;
import com.he.pojo.Menus;
import com.he.service.MenusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("menusService")
public class MenusServiceImpl implements MenusService {

    @Resource
    private MenusDao menusDao;
    @Override
    public Menus queryById(Integer id) {
        return menusDao.queryById(id);
    }

    @Override
    public List<Menus> queryAllMenus() {
        return menusDao.queryAllMenus();
    }

    @Override
    public List<Menus> queryAllByLimit(int offset, int limit) {
        return menusDao.queryAllByLimit(offset, limit);
    }

    @Override
    public int insertMenus(Menus menus) {
        return menusDao.insertMenus(menus);
    }

    @Override
    public int updateMenus(Menus menus) {
        return menusDao.updateMenus(menus);
    }

    @Override
    public boolean deleteById(Integer id) {
        return (menusDao.deleteById(id)>0);
    }
}
