package com.he.dao;

import com.he.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AdminDao {

    Admin queryByName(String name);

    List<Admin> queryAllByLimit(@Param("offset") int offset ,@Param("limit") int limit);

    List<Admin> queryAll(Admin admin);

    int insertAdmin(Admin admin);

    int updateAdmin(Admin admin);

    int deleteById(Integer id);
}
