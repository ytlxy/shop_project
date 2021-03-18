package com.shop.mapper;

import com.shop.pojo.Shop;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ShopDao {
    @Select("select * from shop")
    public List<Shop> findAll() throws Exception;

    @Select("select * from shop where shop_id=#{id}")
    public Shop findById(Integer id) throws Exception;

    @Delete("delete from shop where shop_id=#{id}")
    public void deleteById(Long id) throws Exception;

    @Update("update shop set shop_name=#{shop_name},shop_money=#{shop_money},shop_synopsis=#{shop_synopsis}," +
            "shop_img=#{shop_img},status=#{status},discount=#{discount} where shop_id=#{shop_id}")
    public void findEdit(Shop shop) throws Exception;

    @Update("update shop set shop_name=#{shop_name},shop_money=#{shop_money},discount=#{discount} where shop_id=#{shop_id}")
    public void findEdit2(Shop shop) throws Exception;

    @Insert("insert into shop(shop_name,shop_money,shop_synopsis,shop_img,shop_time,status,discount)" +
            "values(#{shop_name},#{shop_money},#{shop_synopsis},#{shop_img},#{shop_time},1,0)")
    public void addShop(Shop shop) throws Exception;

    @Select("select sum(shop_money) from shop")
    public Integer findAllShopMoney() throws Exception;

    @Select("select COUNT(shop_id) from shop")
    public Long getall() throws Exception;

    @Select("select * from shop where shop_name REGEXP #{shop_name}")
    public List<Shop> searcH(String shop_name) throws Exception;
}
