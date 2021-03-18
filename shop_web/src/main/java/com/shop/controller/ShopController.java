package com.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.Shop;
import com.shop.service.IShopSerivce;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/shop")
@ApiModel("/商品信息")
public class ShopController {

    @Reference
    private IShopSerivce iShopSerivce;

    @ApiOperation("/查询所有商品")
    @GetMapping("/findAll")
    public List<Shop> findAll() throws Exception {
        List<Shop> shop = iShopSerivce.findAll();
        return shop;
    }

    @ApiOperation("/按id查询")
    @GetMapping("/findById")
    public Shop findById(Integer id) throws Exception {
        Shop shop = iShopSerivce.findById(id);
        return shop;
    }

    @ApiOperation("/分页查询")
    @GetMapping("/{page}/{size}/findPage")
    public PageResult findPage(@PathVariable("page") int page,@PathVariable("size") int size) throws Exception {
        return iShopSerivce.findPage(page,size);
    }

    @ApiOperation("/编辑商品")
    @PostMapping("/findEdit")
    public Result findEdit(@RequestBody Shop shop){
        try {
            iShopSerivce.findEdit(shop);
            return new Result(true,"编辑成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"编辑失败");
        }
    }

    @ApiOperation("/新增商品")
    @PostMapping("/addShop")
    public Result addShop(@RequestBody Shop shop){
        try {
            iShopSerivce.addShop(shop);
            return new Result(true,"新增成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"增加失败");
        }
    }

    @ApiOperation("/多选删除")
    @PostMapping("/deleteShop")
    public Result deleteShop(@RequestBody List<Long> ids){
        try {
            iShopSerivce.deleteById(ids);
            return new Result(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @ApiOperation("删除")
    @DeleteMapping("/deleteShopOne")
    public Result deleteShopOne(Long id){
        try {
            iShopSerivce.delete(id);
            return new Result(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @ApiOperation("总条数")
    @GetMapping("/getall")
    public Long getall() throws Exception{
        return iShopSerivce.getall();
    }

    @ApiOperation("搜索")
    @GetMapping("/search")
    public PageResult search(int page,int size,String shop_name) throws Exception{
        return iShopSerivce.searcH(page, size, shop_name);
    }
}
