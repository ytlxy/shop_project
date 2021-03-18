package com.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.User;
import com.shop.service.IUserService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
@ApiModel("/用户信息")
public class UserController {
    @Reference
    private IUserService iUserService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @ApiOperation("登录")
    @GetMapping("/Login/{username}")
    public int Login(@PathVariable("username") String username,String password) throws Exception {
        User user = iUserService.findByUserId(username);
            if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
                return 1;
            } else {
                return 0;
            }
    }

    @ApiOperation("/根据名称查询")
    @GetMapping("/findByName/{username}")
    public User findByName(@PathVariable("username") String username) throws Exception {
        User user = iUserService.findByUserId(username);
        return user;
    }

    @ApiOperation("/分页查询")
    @GetMapping("/{page}/{size}/findPage")
    public PageResult findPage(@PathVariable("page") int page, @PathVariable("size") int size) throws Exception {
        return iUserService.findPage(page, size);
    }

    @ApiOperation("/修改密码")
    @PostMapping("/updatepwd")
    public Result updatepwd(@RequestBody User user) {
        try {
            iUserService.updatapwd(user);
            return new Result(true, "编辑密码成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "编辑密码失败");
        }
    }

    @ApiOperation("/新增用户")
    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user) {
        try {
            iUserService.addUser(user);
            return new Result(true, "新增用户");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "新增失败");
        }
    }

    @ApiOperation("/查询全部")
    @GetMapping("/findAll")
    public List<User> findAll() throws Exception {
        List<User> user = iUserService.findAll();
        return user;
    }

    @ApiOperation("/根据id查询")
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id) throws Exception {
        User user = iUserService.findById(id);
        return user;
    }

    @ApiOperation("/多选删除")
    @PostMapping("/deleteUserList")
    public Result deleteUser(@RequestBody List<Long> ids) {
        try {
            iUserService.deleteById(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    @ApiOperation("删除")
    @DeleteMapping("/deleteUserOne")
    public Result deleteUserOne(Long id) {
        try {
            iUserService.delete(id);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    @ApiOperation("总条数")
    @GetMapping("/getall")
    public Long getall() throws Exception{
        return iUserService.getall();
    }

    @ApiOperation("/修改用户")
    @PostMapping("/updataUser")
    public Result updataUser(@RequestBody User user) {
        try {
            iUserService.updataUser(user);
            return new Result(true, "编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "编辑失败");
        }
    }

    @ApiOperation("搜索")
    @GetMapping("/search")
    public PageResult search(int page,int size,String username) throws Exception{
        return iUserService.searcH(page, size, username);
    }
}
