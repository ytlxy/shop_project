package com.shop.service.impl;

import com.shop.mapper.RoleDao;
import com.shop.pojo.Role;
import com.shop.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IRoleServiceImpl implements IRoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public Role findById(Integer id) throws Exception {
        return roleDao.findById(id);
    }

    @Override
    public void deleteById(List<Long> ids) throws Exception {
        for (Long id:ids){
            roleDao.deleteById(id);
        }
    }
}
