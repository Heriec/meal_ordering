package com.he.service;

import com.he.pojo.Menus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenusService {
    Menus queryById(Integer id);

    List<Menus> queryAllMenus();

    List<Menus> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    int insertMenus(Menus menus);

    int updateMenus(Menus menus);

    boolean deleteById(Integer id);
}
