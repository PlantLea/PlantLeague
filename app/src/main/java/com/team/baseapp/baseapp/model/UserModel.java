package com.team.baseapp.baseapp.model;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.entity.Good;
import com.team.baseapp.baseapp.entity.Image;
import com.team.baseapp.baseapp.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 处理登录用户数据 model
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

    /**
     * 增加购物车
     *
     * @param good
     */
    public void addCart(Good good) {
        if (user == null) {
            return;
        }

        if (user.getCarts() == null) {
            user.setCarts(new ArrayList<Good>());
        }

        user.getCarts().add(good);
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

    /**
     * 获得发布列表
     *
     * @return
     */
    public List<Good> getRelease() {
        if (user == null) {
            return null;
        }

        return user.getReleases();
    }

    /**
     * 获取购物车列表
     *
     * @return
     */
    public List<Good> getCarts() {
        if (user == null) {
            return null;
        }

        if (user.getCarts() == null) {
            //TODO 仅供测试
            user.setCarts(new ArrayList<Good>());
            user.getCarts().add(getTestGood());
        }
        return user.getCarts();
    }

    private Good getTestGood() {
        Good good = new Good();
        good.setName("测试数据");
        good.setId("1234");
        good.setImage(new Image(R.drawable.ic_good2));
        good.setCount(2);
        good.setPrice(9999);
        good.setDate(new Date(System.currentTimeMillis()).toLocaleString());
        good.setDescription("测试使用");
        good.setUser(user == null ? new User("test", "1234") :
                new User(user.getUsr(), user.getPsw()));
        return good;
    }
}
