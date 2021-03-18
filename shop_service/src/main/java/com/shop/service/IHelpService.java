package com.shop.service;


import com.shop.pojo.Helps;

import java.util.List;

public interface IHelpService {
    public List<Helps> findAll() throws Exception;

    public void addhelp(Helps helps) throws Exception;

    public void deleteHelp(List<Long> ids) throws Exception;
}
