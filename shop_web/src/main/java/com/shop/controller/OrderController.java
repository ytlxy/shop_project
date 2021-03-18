package com.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.pojo.Orders;
import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.service.IOrderService;
import com.shop.service.IShopSerivce;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/orders")
@ApiModel("/订单信息")
public class OrderController {
    @Reference
    private IOrderService iOrderService;

    @Reference
    private IShopSerivce iShopSerivce;

    @ApiOperation("/查询订单")
    @GetMapping("/findAll")
    public List<Orders> findAll() throws Exception {
        List<Orders> orders = iOrderService.findAll();
        return orders;
    }

    @ApiOperation("/根据id查询")
    @GetMapping("/findById/{id}")
    public Orders findById(@PathVariable("id") Integer id) throws Exception {
        Orders orders = iOrderService.findById(id);
        return orders;
    }

    @ApiOperation("/分页查询")
    @GetMapping("/{page}/{size}/findPage")
    public PageResult findPage(@PathVariable("page") int page,@PathVariable("size") int size) throws Exception{
        return iOrderService.findPage(page, size);
    }

    @ApiOperation("/新增订单")
    @PostMapping("/addOrder")
    public Result addOrder(@RequestBody Orders orders){
        try {
            iOrderService.addOrder(orders);
            return new Result(true,"增加成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"增加失败");
        }
    }

    @ApiOperation("/编辑商品")
    @PostMapping("/findEdit")
    public Result findEdit(@RequestBody Orders orders){
        try {
            iOrderService.findEdit(orders);
            return new Result(true,"编辑成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"编辑失败");
        }
    }

    @ApiOperation("删除")
    @DeleteMapping("/deleteOrderOne")
    public Result deleteOrderOne(Long id){
        try {
            iOrderService.delete(id);
            return new Result(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }
    @ApiOperation("/多选删除")
    @PostMapping("/deleteOrderList")
    public Result deleteOrderList(@RequestBody List<Long> ids){
        try {
            iOrderService.deleteById(ids);
            return new Result(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除成功");
        }
    }

    @ApiOperation("/总条数")
    @GetMapping("/getall")
    public Integer getall() throws Exception{
        return iOrderService.findAllOrders();
    }

    @ApiOperation("/查询所有金钱")
    @GetMapping("/findAllMoney")
    public Map findAllMoney() throws Exception {
        Integer orders=iOrderService.findAllMoney();
        Integer orderss=iOrderService.findAllOrders();
        Integer shop=iShopSerivce.findAllShopMoney();
        Map map=new HashMap();
        map.put("orders",orders);
        map.put("orderss",orderss);
        map.put("shop",shop);
        return map;
    }

    @ApiOperation("搜索")
    @GetMapping("/search")
    public PageResult search(int page,int size,String order_name) throws Exception{
        return iOrderService.searcH(page, size, order_name);
    }
}
