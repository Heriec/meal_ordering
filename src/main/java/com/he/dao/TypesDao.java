package com.he.dao;

import com.he.pojo.Types;

import java.util.List;

public interface TypesDao {

    List<Types> queryAll();

    int updateTypes(Types type);

    int deleteTypes(int id);

    Types queryById(int id);

    int insertTypes(Types types);
}
