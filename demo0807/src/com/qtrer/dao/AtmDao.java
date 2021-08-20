package com.qtrer.dao;

import com.qtrer.vo.Atm;

public interface AtmDao {
    Atm login(String account, String password);
    Integer pwdChange(String account, String password);
    Integer save(String account, Integer money);
    Integer createAtm(String account, String password);
    Integer deleteAtm(String account);
    Integer pay(String account, Integer money);
}
