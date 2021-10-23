package com.he.service;

import com.he.pojo.Types;

import java.util.List;

public interface TypesService {

    List<Types> queryAll();

    int updateTypes(Types type);

    int deleteTypes(int id);

    Types queryById(int id);

    int insertTypes(Types types);
}
