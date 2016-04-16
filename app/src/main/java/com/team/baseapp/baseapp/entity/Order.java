package com.team.baseapp.baseapp.entity;

import java.util.List;

/**
 * 订单 entity
 * Created by lynnzc on 16-4-16.
 */
public class Order {
    //订单id
    private String orderId;
    //订单商品
    private List<Good> goods;
    //优惠券
    private int coupon;
    //总价
    private int totalPrice;
    //送货地址
    private String address;
    //收件人
    private String owner;
    //收件电话
    private String phone;
    //订单状态
    private int status;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
