package com.qtrer.dao;

import com.qtrer.vo.Atm;

public interface AtmDao {
    Atm queryOne(String account, String password);
    Integer pay(String account, String password, Integer cost);
}
