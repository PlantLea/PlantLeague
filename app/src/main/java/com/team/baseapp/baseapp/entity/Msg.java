package com.team.baseapp.baseapp.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 消息 entity
 * Created by lynnzc on 16-4-16.
 */
public class Msg implements Parcelable {
    private String title;
    private String content;
    private int image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.content);
        dest.writeInt(this.image);
    }

    public Msg() {
    }

    protected Msg(Parcel in) {
        this.title = in.readString();
        this.content = in.readString();
        this.image = in.readInt();
    }

    public static final Parcelable.Creator<Msg> CREATOR = new Parcelable.Creator<Msg>() {
        @Override
        public Msg createFromParcel(Parcel source) {
            return new Msg(source);
        }

        @Override
        public Msg[] newArray(int size) {
            return new Msg[size];
        }
    };
}
