package com.he.service;

import com.he.pojo.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersService {
    //获取全部订单
    List<Orders> pageListQueryAllByLimit(int a,int b);


    //查询全部订单通过id
    List<Orders> pageListByID(int id);

    //查询全部订单通过日期
    List<Orders> pageListByDate(String times1,String times2);

    //查询全部订单通过menu
    List<Orders> pageListByMenus(String name);

    //查找所有订单通过delivery
    List<Orders> pageListByDelivery(@Param("a") int a, @Param("b") int b);

    List<Orders> queryOrdersByIdAndDelivery(Integer id,int delivery);
    //增加order
    int insertOrders(Orders orders);
    //更新delivery
    int updateOrdersDelivery(Integer id);

    //删除订单
    int deleteOrders(Integer id);
    //获取全部行数
    int pageCount();

    int pageCountDelivery();
}
