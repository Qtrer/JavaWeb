package com.qtrer.daoImpl;

import com.qtrer.dao.DishDao;
import com.qtrer.utils.DBExecute;
import com.qtrer.vo.Dish;

import java.util.List;

public class DishDaoImpl implements DishDao {
    @Override
    public List<Dish> queryAll() {
        return DBExecute.executeQuery(Dish.class, "select * from dish");
    }

    @Override
    public Integer sold(Integer id, Integer left) {
        return DBExecute.executeUpdate("update dish set number=? where id=?",left, id);
    }
}
