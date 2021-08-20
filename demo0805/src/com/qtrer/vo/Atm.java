package com.qtrer.vo;

public class Atm {
    private String account;
    private String password;
    private Integer remain;

    public Atm() {
    }

    public Atm(String account, String password, Integer remain) {
        this.account = account;
        this.password = password;
        this.remain = remain;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    @Override
    public String toString() {
        return "Atm{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", remain=" + remain +
                '}';
    }
}
