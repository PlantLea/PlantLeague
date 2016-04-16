package com.team.baseapp.baseapp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 图片 entity
 * Created by lynnzc on 16-4-16.
 */
public class Image implements Parcelable {
    //小图
    private String avatar;
    //图片列表
    private List<String> images;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Image{" +
                "avatar='" + avatar + '\'' +
                ", images=" + images +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.avatar);
        dest.writeStringList(this.images);
    }

    public Image() {
    }

    protected Image(Parcel in) {
        this.avatar = in.readString();
        this.images = in.createStringArrayList();
    }

    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };
}
