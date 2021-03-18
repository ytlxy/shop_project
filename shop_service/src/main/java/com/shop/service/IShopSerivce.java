package com.shop.service;


import com.shop.pojo.PageResult;
import com.shop.pojo.Shop;

import java.util.List;

public interface IShopSerivce {
    public List<Shop> findAll() throws Exception;

    public Shop findById(Integer id) throws Exception;

    public PageResult findPage(int page, int size)throws Exception;

    public void deleteById(List<Long> ids) throws Exception;

    public void delete(Long id) throws Exception;

    public void findEdit(Shop shop) throws Exception;

    public void addShop(Shop shop) throws Exception;

    public Integer findAllShopMoney() throws Exception;

    public void findEdit2(Shop shop) throws Exception;

    public Long getall() throws Exception;

    public PageResult searcH(int page,int size,String shop_name) throws Exception;
}
