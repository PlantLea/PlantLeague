package com.team.baseapp.baseapp.model;

import com.team.baseapp.baseapp.entity.User;

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
}
