package com.shop.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shop.mapper.HelpsDao;
import com.shop.pojo.Helps;
import com.shop.service.IHelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IHelpServiceImpl implements IHelpService {
    @Autowired
    private HelpsDao helpsDao;

    @Override
    public List<Helps> findAll() throws Exception {
        return helpsDao.findAll();
    }

    @Override
    public void addhelp(Helps helps) throws Exception {
        helpsDao.addhelp(helps);
    }

    @Override
    public void deleteHelp(List<Long> ids) throws Exception {
        for (Long id:ids){
            helpsDao.deleteHelp(id);
        }
    }
}
