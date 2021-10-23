package com.he.controller;

import com.he.pojo.Types;
import com.he.service.TypesService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("types")
public class TypesController {
    @Autowired
    @Qualifier("typesService")
    private TypesService typesService;

    @RequestMapping("queryAll")
    public String queryAll(Model model) {
        List<Types> types = typesService.queryAll();
        model.addAttribute("types", types);
        return "admin/type";
    }

    @RequestMapping("insert")
    public String insert(Model model, @Param("name") String name) {
        int id = (int) (System.currentTimeMillis() % 100);
        typesService.insertTypes(new Types(id, name));
        return queryAll(model);
    }

    @RequestMapping("queryById")
    public String queryById(Model model, @Param("id") int id) {
        Types types = typesService.queryById(id);
        model.addAttribute("type", types);
        System.out.println(types);
        return "admin/type_update";
    }

    @RequestMapping("delete")
    public String delete(Model model, @Param("id") int id) {
        int i = typesService.deleteTypes(id);
        return queryAll(model);
    }

    @RequestMapping("update")
    public String update(Model model, Types types) {
        System.out.println(types);
        typesService.updateTypes(types);
        return queryAll(model);

    }
}
