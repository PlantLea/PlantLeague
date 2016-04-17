package com.team.baseapp.baseapp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片 entity
 * Created by lynnzc on 16-4-16.
 */
public class Image implements Parcelable {
    //小图
    private int avatar;
    //图片列表
    private List<Integer> images;

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public List<Integer> getImages() {
        return images;
    }

    public void setImages(List<Integer> images) {
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
        dest.writeInt(this.avatar);
        dest.writeList(this.images);
    }

    public Image() {
    }

    protected Image(Parcel in) {
        this.avatar = in.readInt();
        this.images = new ArrayList<Integer>();
        in.readList(this.images, Integer.class.getClassLoader());
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
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
