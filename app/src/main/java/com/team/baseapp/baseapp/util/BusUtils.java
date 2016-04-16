package com.team.baseapp.baseapp.util;

import com.team.baseapp.baseapp.event.BaseEvent;
import com.team.baseapp.baseapp.exception.IllegalInstanceException;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by lynnzc on 16-3-18.
 */
public class BusUtils {
    private BusUtils() {
        throw new IllegalInstanceException();
    }

    /**
     * EventBus 注册 helper
     *
     * @param context
     */
    public static void register(Object context) {
        //如果还没有注册, 则注册
        if (!EventBus.getDefault().isRegistered(context)) {
//            EventBus.getDefault().register(context);
        }
    }

    /**
     * EventBus 取消注册 helper
     *
     * @param context
     */
    public static void unregister(Object context) {
        //如果已经注册了, 则取消注册
        if (EventBus.getDefault().isRegistered(context)) {
//            EventBus.getDefault().unregister(context);
        }
    }


    public static <T extends BaseEvent> void postEvent(T event) {
        EventBus.getDefault().post(event);
    }
}
