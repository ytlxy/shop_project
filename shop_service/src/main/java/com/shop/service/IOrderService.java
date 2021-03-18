package com.shop.service;

import com.shop.pojo.Orders;
import com.shop.pojo.PageResult;

import java.util.List;

public interface IOrderService {
    public List<Orders> findAll() throws Exception;

    public Orders findById(Integer id) throws Exception;

    public PageResult findPage(int page,int size) throws Exception;

    public void deleteById(List<Long> ids) throws Exception;

    public void findEdit(Orders orders) throws Exception;

    public void delete(Long id) throws Exception;

    public void addOrder(Orders orders) throws Exception;

    public Integer findAllMoney() throws Exception;

    public Integer findAllOrders() throws Exception;

    public PageResult searcH(int page,int size,String order_name) throws Exception;
}
