package com.qtrer.service;

import com.qtrer.dao.AtmDao;
import com.qtrer.dao.DishDao;
import com.qtrer.daoImpl.AtmDaoImpl;
import com.qtrer.daoImpl.DishDaoImpl;
import com.qtrer.vo.Atm;
import com.qtrer.vo.Dish;

import java.util.List;

public class LoginService {
    private AtmDao atmDao;
    private DishDao dishDao;
    public LoginService(){
        atmDao = new AtmDaoImpl();
        dishDao = new DishDaoImpl();
    }
    public Atm login(String username, String password){
        return atmDao.queryOne(username, password);
    }
    public List<Dish> dishlist(){
        return dishDao.queryAll();
    }
}
