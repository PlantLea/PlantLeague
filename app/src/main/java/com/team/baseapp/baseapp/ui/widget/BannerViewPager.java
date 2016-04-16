package com.team.baseapp.baseapp.ui.widget;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.team.baseapp.baseapp.ui.adapter.BannerPagerAdapter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 轮播 viewpager
 * Created by lynnzc on 16-4-16.
 */
public class BannerViewPager extends ViewPager {
    //自定义注解, 注解status参数
    @IntDef({
            RESUME,
            PAUSE,
            DESTROY
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface Life {

    }

    //状态值
    public static final int RESUME = 0;
    public static final int PAUSE = 1;
    public static final int DESTROY = 2;
    //默认周期 2秒
    public static final int DEFAULT_CYCLE = 2000;

    //当前状态记录
    private int mLife = RESUME;

    //是否在触碰
    private boolean mIsTouching = false;

    //轮播定时
    private ScheduledExecutorService mTimer;

    //轮播周期
    private int cycle;
    //dot container
    private LinearLayout dotContainer = null;
    //previous position
    private int prePosition;

    public BannerViewPager(Context context) {
        super(context);
        init();
    }

    public BannerViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        //使用默认周期
        this.cycle = DEFAULT_CYCLE;
        this.prePosition = 0;

        addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                //dot 跟着image变换同时变换
                if (dotContainer != null) {
                    int newPos = position % ((BannerPagerAdapter) getAdapter()).getImageCount();
                    //切换状态
                    dotContainer.getChildAt(newPos).setEnabled(true);
                    //还原状态
                    dotContainer.getChildAt(prePosition).setEnabled(false);
                    prePosition = newPos;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void setDotContainer(LinearLayout dotContainer) {
        this.dotContainer = dotContainer;
    }

    public LinearLayout getDotContainer() {
        return dotContainer;
    }

    /**
     * 设置状态
     */
    public void setStatus(@Life int status) {
        this.mLife = status;
    }

    /**
     * 设置周期
     */
    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    /**
     * 变更触摸状态
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                mIsTouching = true;
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                mIsTouching = false;
                break;
        }
        return super.onTouchEvent(ev);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        //保证定时器重设
        stopTimer();
        //初始化定时器
        mTimer = Executors.newSingleThreadScheduledExecutor();
        mTimer.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                switch (mLife) {
                    case RESUME:
                        if (!mIsTouching &&
                                getAdapter() != null &&
                                getAdapter().getCount() > 1) {
                            //至少不是触摸屏幕下, 图片资源大于1
                            //才能触发自动轮播效果
                            post(new Runnable() {
                                @Override
                                public void run() {
                                    //切换到下一张图片
                                    setCurrentItem(getCurrentItem() + 1);
                                }
                            });
                        }
                        break;
                    case PAUSE:
                        //TODO 暂时什么都不做
                        break;
                    case DESTROY:
                    default:
                        //销毁定时器
                        stopTimer();
                        break;
                }
            }
        }, cycle, cycle, TimeUnit.MILLISECONDS);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        //销毁定时器
        stopTimer();
    }

    /**
     * 停止定时器
     */
    private void stopTimer() {
        if (mTimer != null && !mTimer.isShutdown()) {
            //未停止
            mTimer.shutdown();
        }
        mTimer = null;
    }
}
