package com.qtrer.dao;

import com.qtrer.vo.Dish;

import java.util.List;

public interface DishDao {
    List<Dish> queryAll();
    Integer sold(Integer id, Integer left);
}
