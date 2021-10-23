package com.he.service.impl;

import com.he.dao.AdminDao;
import com.he.pojo.Admin;
import com.he.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    @Override
    public Admin queryByName(String name) {
        return this.adminDao.queryByName(name);
    }

    @Override
    public List<Admin> queryAllByLimit(int offset, int limit) {
        return this.adminDao.queryAllByLimit(offset, limit);
    }

    @Override
    public int insertAdmin(Admin admin) {
        return this.adminDao.insertAdmin(admin);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return this.adminDao.updateAdmin(admin);
    }

    @Override
    public boolean deleteById(Integer id) {
            return this.adminDao.deleteById(id)>0;

    }
    //登录方法的实现,从jsp页面获取username与password
    public Admin login(String name, String pwd) {
        Admin admin = null;
        admin = adminDao.queryByName(name);
        if (admin != null) {
            if (admin.getName().equals(name) && admin.getPwd().equals(pwd))
                return admin;
        }
        admin = null;
        return admin;
    }
}
