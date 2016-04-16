package com.team.baseapp.baseapp.model;

import com.team.baseapp.baseapp.entity.Good;

import java.util.List;

/**
 * 购物车 model
 * Created by lynnzc on 16-4-16.
 */
public class CartModel {
    //绑定用户的未付款订单
    private List<Good> goods;

    public CartModel(List<Good> goods) {
        this.goods = goods;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    /**
     * 返回购物车商品数量
     *
     * @return
     */
    public int size() {
        //后面加上divider size
        return goods == null ? 0 : goods.size();
    }

    /**
     * 返回某个具体的商品
     *
     * @param i
     * @return
     */
    public Good get(int i) {
        return goods == null ? null : goods.get(i);
    }
}
