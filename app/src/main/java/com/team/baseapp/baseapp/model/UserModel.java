package com.team.baseapp.baseapp.model;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.entity.Good;
import com.team.baseapp.baseapp.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理登录用户 model
 * Created by lynnzc on 16-4-16.
 */
public class UserModel {
    private User user;

    private UserModel() {
        user = new User();
    }

    private static final class UserModelHolder {
        private static final UserModel INSTANCE = new UserModel();
    }

    public static UserModel getInstance() {
        return UserModelHolder.INSTANCE;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 返回是否登录
     *
     * @return
     */
    public boolean isLogin() {
        return user != null &&
                user.getUsr() != null &&
                !user.getUsr().equals("");
    }

    public String getNickname() {
        return user == null ? "" : user.getNickname();
    }

    public String getDescription() {
        return user == null ? "" : user.getDescription();
    }

    public int getAvatar() {
        return user == null ? R.drawable.ic_default_avatar : user.getAvatar();
    }

    //增加发布
    public void addRelease(Good good) {
        if (user == null) {
            return;
        }

        if (user.getReleases() == null) {
            user.setReleases(new ArrayList<Good>());
        }

        user.getReleases().add(good);
    }

    public List<Good> getRelease() {
        if (user == null) {
            return null;
        }

        return user.getReleases();
    }
}
