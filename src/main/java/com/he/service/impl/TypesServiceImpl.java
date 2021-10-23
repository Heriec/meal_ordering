package com.he.service.impl;

import com.he.dao.TypesDao;
import com.he.pojo.Types;
import com.he.service.TypesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("typesService")
public class TypesServiceImpl implements TypesService{
    @Resource
    private TypesDao typesDao;
    @Override
    public List<Types> queryAll() {
        return typesDao.queryAll();
    }

    @Override
    public int updateTypes(Types type) {
        return typesDao.updateTypes(type);
    }

    @Override
    public int deleteTypes(int id) {
        return typesDao.deleteTypes(id);
    }

    @Override
    public Types queryById(int id) {
        return typesDao.queryById(id);
    }

    @Override
    public int insertTypes(Types types) {
        return typesDao.insertTypes(types);
    }
}
