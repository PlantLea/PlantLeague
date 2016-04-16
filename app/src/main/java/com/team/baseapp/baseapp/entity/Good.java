package com.team.baseapp.baseapp.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 商品 entity
 * Created by lynnzc on 16-4-16.
 */
public class Good implements Parcelable {
    //商品id
    private String id;
    //商品名
    private String name;
    //商品描述
    private String description;
    //商品图片
    private Image image;
    //商品价格
    private int price;
    //发布日期
    private String date;
    //发布者
    private User user;
    //数量
    private int count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", user=" + user +
                ", count=" + count +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeParcelable(this.image, flags);
        dest.writeInt(this.price);
        dest.writeString(this.date);
        dest.writeParcelable(this.user, flags);
        dest.writeInt(this.count);
    }

    public Good() {
    }

    protected Good(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.description = in.readString();
        this.image = in.readParcelable(Image.class.getClassLoader());
        this.price = in.readInt();
        this.date = in.readString();
        this.user = in.readParcelable(User.class.getClassLoader());
        this.count = in.readInt();
    }

    public static final Creator<Good> CREATOR = new Creator<Good>() {
        @Override
        public Good createFromParcel(Parcel source) {
            return new Good(source);
        }

        @Override
        public Good[] newArray(int size) {
            return new Good[size];
        }
    };
}
