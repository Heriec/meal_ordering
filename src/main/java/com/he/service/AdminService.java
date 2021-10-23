package com.he.service;

import com.he.pojo.Admin;

import java.util.List;

public interface AdminService {
    Admin queryByName(String name);

    Admin login(String name, String pwd);

    List<Admin> queryAllByLimit(int offset, int limit);

    int insertAdmin(Admin admin);

    int updateAdmin(Admin admin);

    boolean deleteById(Integer id);
}
