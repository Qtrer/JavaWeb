package com.qtrer.service;

import com.qtrer.dao.AtmDao;
import com.qtrer.dao.DishDao;
import com.qtrer.daoImpl.AtmDaoImpl;
import com.qtrer.daoImpl.DishDaoImpl;

public class BuyService {
    private AtmDao atmDao;
    private DishDao dishDao;
    public BuyService(){
        atmDao = new AtmDaoImpl();
        dishDao = new DishDaoImpl();
    }
    public Integer cost(String account, String password, Integer cost){
        return atmDao.pay(account, password, cost);
    }
    public Integer sold(Integer id, Integer left){
        return dishDao.sold(id, left);
    }
}
