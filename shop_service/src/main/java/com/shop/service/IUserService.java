package com.shop.service;

import com.shop.pojo.PageResult;
import com.shop.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService  extends UserDetailsService {
    public List<User> findAll() throws Exception;

    public User findById(Integer id) throws Exception;

    public void deleteById(List<Long> ids) throws Exception;

    public void delete(Long id) throws Exception;

    public PageResult findPage(int page, int size)throws Exception;

    public User findByUserId(String name) throws Exception;

    public void updatapwd(User user) throws Exception;

    public void addUser(User user) throws Exception;

    public Long getall()throws Exception;

    public void updataUser(User user) throws Exception;

    public PageResult searcH(int page,int size,String username) throws Exception;
}
