package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.mapper.ShopDao;
import com.shop.pojo.PageResult;
import com.shop.pojo.Shop;
import com.shop.service.IShopSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class IShopServiceImpl implements IShopSerivce {
    @Autowired
    private ShopDao shopDao;

    @Override
    public List<Shop> findAll() throws Exception {
        return shopDao.findAll();
    }

    @Override
    public Shop findById(Integer id) throws Exception {
        return shopDao.findById(id);
    }

    @Override
    public PageResult findPage(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        Page<Shop> page1=(Page<Shop>) shopDao.findAll();
        return new PageResult(page1.getTotal(),page1.getResult());
    }

    @Override
    public void deleteById(List<Long> ids) throws Exception {
        for(Long id : ids){
            shopDao.deleteById(id);
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        shopDao.deleteById(id);
    }

    @Override
    public void findEdit(Shop shop) throws Exception {
        shopDao.findEdit(shop);
    }

    @Override
    public void addShop(Shop shop) throws Exception {
        if(shop.getDiscount()==null){
            shop.setDiscount(0);
        }
        shop.setShop_time(new Date());
        shopDao.addShop(shop);
    }

    @Override
    public Integer findAllShopMoney() throws Exception {
        return shopDao.findAllShopMoney();
    }

    @Override
    public void findEdit2(Shop shop) throws Exception {
        shopDao.findEdit2(shop);
    }

    @Override
    public Long getall() throws Exception {
        return shopDao.getall();
    }

    @Override
    public PageResult searcH(int page,int size,String shop_name) throws Exception {
        PageHelper.startPage(page,size);
        Page<Shop> page1=(Page<Shop>) shopDao.searcH(shop_name);
        return new PageResult(page1.getTotal(),page1.getResult());
    }
}
