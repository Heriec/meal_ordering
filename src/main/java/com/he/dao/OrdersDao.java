package com.he.dao;

import com.he.pojo.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersDao {
    //获取全部订单
    List<Orders> pageListQueryAllByLimit(@Param("a") int a, @Param("b") int b);

    //查询全部订单通过id
    List<Orders> pageListById(int id);

    //查询全部订单通过日期
    List<Orders> pageListByDate(@Param("times1") String times1, @Param("times2") String times2);

    //查询全部订单通过menu
    List<Orders> pageListByMenus(@Param("name") String name);

    //查找所有订单通过delivery
    List<Orders> pageListByDelivery(@Param("a") int a, @Param("b") int b);

    List<Orders> queryOrdersByIdAndDelivery(@Param("id") Integer id,@Param("delivery")int delivery);

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
