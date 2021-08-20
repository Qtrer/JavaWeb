package com.qtrer.daoImpl;

import com.qtrer.dao.AtmDao;
import com.qtrer.utils.DBExecute;
import com.qtrer.vo.Atm;

public class AtmDaoImpl implements AtmDao {
    @Override
    public Atm queryOne(String account, String password) {
        return DBExecute.executeQuery(Atm.class, "select * from atm where account=? and password=?",account, password).get(0);
    }

    @Override
    public Integer pay(String account, String password, Integer cost) {
        return DBExecute.executeUpdate("update atm set remain=? where account=? and password=?",cost, account, password);
    }
}
