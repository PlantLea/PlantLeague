package com.team.baseapp.baseapp.entity;

/**
 * 我 菜单 menu entity
 * Created by lynnzc on 16-4-16.
 */
public class Menu {
    private String title;
    private int resId;

    public Menu(String title) {
        this(title, -1);
    }

    public Menu(int resId) {
        this("", resId);
    }

    public Menu(String title, int resId) {
        this.title = title;
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
