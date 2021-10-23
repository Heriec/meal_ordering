package com.he.service;

import com.he.pojo.Users;
import org.apache.ibatis.annotations.Param;

public interface UsersService {
    //登录查询，查询一个对象
    Users login(@Param("name") String name, @Param("pwd") String pwd);

    //根据ID查询
    Users queryById(Integer id);

    //插入用户
    int insertUser(Users user);

    //修改用户
    int updateUser(Users user);

    //删除用户通过id
    int deleteById(Integer id);


}
