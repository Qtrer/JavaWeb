package com.qtrer.vo;

public class Dish {
    private Integer id;
    private String name;
    private Integer price;
    private Integer number;
    private Integer sid;

    public Dish() {
    }

    public Dish(Integer id, String name, Integer price, Integer number, Integer sid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.sid = sid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", sid=" + sid +
                '}';
    }
}
