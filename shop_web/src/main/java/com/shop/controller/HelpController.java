package com.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.pojo.Helps;
import com.shop.pojo.Result;
import com.shop.service.IHelpService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/help")
@ApiModel("/帮助信息")
public class HelpController {
    @Reference
    private IHelpService iHelpService;

    @ApiOperation("/查询帮助信息")
    @GetMapping("/findAll")
    public List<Helps> findAll() throws Exception {
        List<Helps> helps = iHelpService.findAll();
        return helps;
    }

    @ApiOperation("/新增帮助信息")
    @PostMapping("/addhelp")
    public Result addhelp(@RequestBody Helps helps){
        try {
            iHelpService.addhelp(helps);
            return new Result(true,"新增成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"新增失败");
        }
    }

    @ApiOperation("/多选删除")
    @PostMapping("/deletehelp")
    public Result deletehelp(@RequestBody List<Long> ids) {
        try{
            iHelpService.deleteHelp(ids);
            return new Result(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }
}
