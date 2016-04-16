package com.team.baseapp.baseapp.entity;

/**
 * 商品 entity
 * Created by lynnzc on 16-4-16.
 */
public class Good {
    //商品名
    private String name;
    //商品描述
    private String description;
    //商品图片
    private String image;
    //商品价格
    private int price;
    //发布者
    private User user;
    //数量
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
