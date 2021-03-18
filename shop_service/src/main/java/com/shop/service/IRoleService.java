package com.shop.service;


import com.shop.pojo.Role;

import java.util.List;

public interface IRoleService {

    public Role findAll() throws Exception;

    public Role findById(Integer id) throws Exception;

    public void deleteById(List<Long> ids) throws Exception;
}
