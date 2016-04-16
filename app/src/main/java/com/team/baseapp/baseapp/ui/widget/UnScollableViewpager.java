package com.team.baseapp.baseapp.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by lynnzc on 16-4-16.
 */
public class UnScollableViewpager extends ViewPager {
    public UnScollableViewpager(Context context) {
        super(context);
    }

    public UnScollableViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //禁止滑动
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
