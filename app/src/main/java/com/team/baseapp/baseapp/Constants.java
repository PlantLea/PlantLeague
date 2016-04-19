package com.team.baseapp.baseapp;

/**
 * 常量
 * Created by lynnzc on16-4-16.
 */
public class Constants {
    //待支付
    public static final int ORDER_STATUS_UNPAID = 1;
    //已支付
    public static final int ORDER_STATUS_PAID = 2;
    //已发货
    public static final int ORDER_STATUS_SHIPED = 3;
    //已收货
    public static final int ORDER_STATUS_RECEIVED = 4;
    //申请退货
    public static final int ORDER_STATUS_APPLY_RETURN = 5;
    //已退货
    public static final int ORDER_STATUS_RETURN = 6;
    //已退款
    public static final int ORDER_STATUS_REFUND = 7;

    public static final String PARAM_GOOD_DATA = "good_data";
}
