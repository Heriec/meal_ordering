package com.he.service.impl;

import com.he.dao.OrdersDao;
import com.he.pojo.Orders;
import com.he.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Resource
    private OrdersDao ordersDao;

    @Override
    public List<Orders> pageListQueryAllByLimit(int a, int b) {
        return ordersDao.pageListQueryAllByLimit(a,b );
    }

    @Override
    public List<Orders> pageListByID(int id) {
        return ordersDao.pageListById(id);
    }

    @Override
    public List<Orders> pageListByDate(String times1, String times2) {
        return ordersDao.pageListByDate(times1, times2);
    }

    @Override
    public List<Orders> pageListByMenus(String name) {
        return ordersDao.pageListByMenus(name);
    }

    @Override
    public List<Orders> pageListByDelivery(int a, int b) {
        return ordersDao.pageListByDelivery(a, b);
    }

    @Override
    public List<Orders> queryOrdersByIdAndDelivery(Integer id, int delivery) {
        return ordersDao.queryOrdersByIdAndDelivery(id, delivery);
    }

    @Override
    public int insertOrders(Orders orders) {
        return ordersDao.insertOrders(orders);
    }

    @Override
    public int updateOrdersDelivery(Integer id) {
        return ordersDao.updateOrdersDelivery(id);
    }

    @Override
    public int deleteOrders(Integer id) {
        return ordersDao.deleteOrders(id);
    }

    @Override
    public int pageCount() {
        return ordersDao.pageCount();
    }

    @Override
    public int pageCountDelivery() {
        return ordersDao.pageCountDelivery();
    }
}
