package com.team.baseapp.baseapp.model;

/**
 * 我 菜单 menu view
 * Created by lynnzc on 16-4-16.
 */
public class MenuModel {
    private String title;
    private int resId;

    public MenuModel(String title, int resId) {
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
