package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.mapper.OrderDao;
import com.shop.pojo.Orders;
import com.shop.pojo.PageResult;
import com.shop.pojo.User;
import com.shop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IOrderServiceImpl implements IOrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public List<Orders> findAll() throws Exception {
        return orderDao.findAll();
    }

    @Override
    public Orders findById(Integer id) throws Exception {
        return orderDao.findById(id);
    }

    @Override
    public PageResult findPage(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        Page<Orders> page1=(Page<Orders>) orderDao.findAll();
        return new PageResult(page1.getTotal(),page1.getResult());
    }

    @Override
    public void deleteById(List<Long> ids) throws Exception {
        for (Long id:ids){
            orderDao.deleteById(id);
        }
    }

    @Override
    public void findEdit(Orders orders) throws Exception {
        orderDao.findEdit(orders);
    }

    @Override
    public void delete(Long id) throws Exception {
        orderDao.deleteById(id);
    }


    @Override
    public void addOrder(Orders orders) throws Exception {
        orderDao.addOrder(orders);
    }

    @Override
    public Integer findAllMoney() throws Exception {
        return orderDao.findAllMoney();
    }

    @Override
    public Integer findAllOrders() throws Exception {
        return orderDao.findAllOrders();
    }

    @Override
    public PageResult searcH(int page, int size, String order_name) throws Exception {
        PageHelper.startPage(page,size);
        Page<Orders> page1=(Page<Orders>) orderDao.searcH(order_name);
        return new PageResult(page1.getTotal(),page1.getResult());
    }
}
