package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.mapper.UserDao;
import com.shop.pojo.PageResult;
import com.shop.pojo.Role;
import com.shop.pojo.Shop;
import com.shop.pojo.User;
import com.shop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class IUserServiceImpl implements IUserService {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userDao.findByUserId(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        org.springframework.security.core.userdetails.User user0 = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user.getRoles()));
        org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getStatus() == 1 ? true : false, true, true, true, getAuthority(user.getRoles()));
        return user1;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (Role role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return simpleGrantedAuthorities;
    }

    @Override
    public List<User> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    public User findById(Integer id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public void deleteById(List<Long> ids) throws Exception {
        for(Long id:ids){
            userDao.deleteById(id);
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        userDao.deleteById(id);
    }

    @Override
    public PageResult findPage(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        Page<User> page1=(Page<User>) userDao.findAll();
        return new PageResult(page1.getTotal(),page1.getResult());
    }

    @Override
    public User findByUserId(String name) throws Exception {
        return userDao.findByUserId(name);
    }

    @Override
    public void updatapwd(User user) throws Exception {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.updatapwd(user);
    }

    @Override
    public void addUser(User user) throws Exception {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUser_money(0.00);
        user.setUser_time(new Date());
        if(user.getUser_header().equals("")) {
            user.setUser_header("https://s3.ax1x.com/2020/12/07/DvlnhT.jpg");
        }
        userDao.addUser(user);
        userDao.addUserRole(userDao.gitid());
    }

    @Override
    public Long getall() throws Exception {
        return userDao.getall();
    }

    @Override
    public void updataUser(User user) throws Exception {
        userDao.updataUser(user);
    }

    @Override
    public PageResult searcH(int page, int size, String username) throws Exception {
        PageHelper.startPage(page,size);
        Page<User> page1=(Page<User>) userDao.searcH(username);
        return new PageResult(page1.getTotal(),page1.getResult());
    }

}
