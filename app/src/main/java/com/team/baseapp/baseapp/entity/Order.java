package com.team.baseapp.baseapp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 订单 entity
 * Created by lynnzc on 16-4-16.
 */
public class Order implements Parcelable {
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

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", goods=" + goods +
                ", coupon=" + coupon +
                ", totalPrice=" + totalPrice +
                ", address='" + address + '\'' +
                ", owner='" + owner + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.orderId);
        dest.writeTypedList(goods);
        dest.writeInt(this.coupon);
        dest.writeInt(this.totalPrice);
        dest.writeString(this.address);
        dest.writeString(this.owner);
        dest.writeString(this.phone);
        dest.writeInt(this.status);
    }

    public Order() {
    }

    protected Order(Parcel in) {
        this.orderId = in.readString();
        this.goods = in.createTypedArrayList(Good.CREATOR);
        this.coupon = in.readInt();
        this.totalPrice = in.readInt();
        this.address = in.readString();
        this.owner = in.readString();
        this.phone = in.readString();
        this.status = in.readInt();
    }

    public static final Parcelable.Creator<Order> CREATOR = new Parcelable.Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel source) {
            return new Order(source);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };
}
