package com.he.service.impl;

import com.he.dao.UsersDao;
import com.he.pojo.Users;
import com.he.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersDao usersDao;
    @Override
    public Users login(String name, String pwd) {
        Users user= usersDao.queryOne(name,pwd);
        if(user.getPwd().equals(pwd))
            return user;
        else
            return null;
    }

    @Override
    public Users queryById(Integer id) {
        return usersDao.queryById(id);
    }

    @Override
    public int insertUser(Users user) {
        return usersDao.insertUser(user);
    }

    @Override
    public int updateUser(Users user) {
        return usersDao.updateUser(user);
    }

    @Override
    public int deleteById(Integer id) {
        return usersDao.deleteById(id);
    }
}
