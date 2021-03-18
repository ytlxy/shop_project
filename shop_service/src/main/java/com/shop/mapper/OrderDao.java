package com.shop.mapper;


import com.shop.pojo.Orders;
import com.shop.pojo.Shop;
import com.shop.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.core.annotation.Order;

import java.util.List;
@Mapper
public interface OrderDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "order_id", column = "order_id"),
            @Result(property = "order_name", column = "order_name"),
            @Result(property = "order_money", column = "order_money"),
            @Result(property = "order_synopsis", column = "order_synopsis"),
            @Result(property = "order_time", column = "order_time"),
            @Result(property = "order_shop", column = "order_shop"),
            @Result(property = "shops", column = "order_shop", javaType = Shop.class, one = @One(select = "com.shop.mapper.ShopDao.findById"))
    })
    public List<Orders> findAll() throws Exception;

    @Select("select * from orders where order_id=#{order_id}")
    public Orders findById(Integer id) throws Exception;

    @Update("update orders set order_name=#{order_name},order_money=#{order_money},order_synopsis=#{order_synopsis},order_time=#{order_time},order_shop=#{order_shop},status=#{status} where order_id=#{order_id}")
    public void findEdit(Orders orders) throws Exception;

    @Delete("delete from orders where order_id=#{order_id}")
    public void deleteById(Long id) throws Exception;

    @Insert("insert into orders(order_name,order_money,order_synopsis,order_time,status)values(#{order_name}," +
            "#{order_money},#{order_synopsis},#{order_time},1)")
    public void addOrder(Orders orders) throws Exception;

    @Select("select sum(order_money) from orders")
    public Integer findAllMoney() throws Exception;

    @Select("select count(order_id) from orders")
    public Integer findAllOrders() throws Exception;

    @Select("select * from orders where order_name REGEXP #{order_name}")
    public List<Orders> searcH(String order_name) throws Exception;
}
