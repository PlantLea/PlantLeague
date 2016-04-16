package com.team.baseapp.baseapp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * app 用户
 * Created by lynnzc on 16-3-26.
 */
public class User implements Parcelable {
    //账号 key
    private String usr;
    //密码
    private String psw;
    //昵称
    private String nickname;
    //性别
    private boolean sex;
    //头像
    private String avatar;
    //简介
    private String description;
    //电话
    private String phone;
    //余额
    private int balance;
    //送货地址列表
    private List<Address> addresss;
    //发布商品列表
    private List<Good> releases;
    //卖出列表
    private List<Good> solds;
    //我的订单
    private List<Order> orders;
    //收藏
    private List<Good> marks;
    //购物车
    private List<Good> carts;

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Good> getReleases() {
        return releases;
    }

    public void setReleases(List<Good> releases) {
        this.releases = releases;
    }

    public List<Good> getSolds() {
        return solds;
    }

    public void setSolds(List<Good> solds) {
        this.solds = solds;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Good> getMarks() {
        return marks;
    }

    public void setMarks(List<Good> marks) {
        this.marks = marks;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Address> getAddresss() {
        return addresss;
    }

    public void setAddresss(List<Address> addresss) {
        this.addresss = addresss;
    }

    public List<Good> getCarts() {
        return carts;
    }

    public void setCarts(List<Good> carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "User{" +
                "usr='" + usr + '\'' +
                ", psw='" + psw + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", avatar='" + avatar + '\'' +
                ", description='" + description + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                ", addresss=" + addresss +
                ", releases=" + releases +
                ", solds=" + solds +
                ", orders=" + orders +
                ", marks=" + marks +
                ", carts=" + carts +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.usr);
        dest.writeString(this.psw);
        dest.writeString(this.nickname);
        dest.writeByte(sex ? (byte) 1 : (byte) 0);
        dest.writeString(this.avatar);
        dest.writeString(this.description);
        dest.writeString(this.phone);
        dest.writeInt(this.balance);
        dest.writeTypedList(addresss);
        dest.writeTypedList(releases);
        dest.writeTypedList(solds);
        dest.writeTypedList(orders);
        dest.writeTypedList(marks);
        dest.writeTypedList(carts);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.usr = in.readString();
        this.psw = in.readString();
        this.nickname = in.readString();
        this.sex = in.readByte() != 0;
        this.avatar = in.readString();
        this.description = in.readString();
        this.phone = in.readString();
        this.balance = in.readInt();
        this.addresss = in.createTypedArrayList(Address.CREATOR);
        this.releases = in.createTypedArrayList(Good.CREATOR);
        this.solds = in.createTypedArrayList(Good.CREATOR);
        this.orders = in.createTypedArrayList(Order.CREATOR);
        this.marks = in.createTypedArrayList(Good.CREATOR);
        this.carts = in.createTypedArrayList(Good.CREATOR);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
