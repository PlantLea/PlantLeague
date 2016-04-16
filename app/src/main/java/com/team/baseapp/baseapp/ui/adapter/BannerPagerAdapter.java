package com.team.baseapp.baseapp.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.model.BannerModel;
import com.team.baseapp.baseapp.ui.widget.BannerViewPager;

/**
 * 轮播adapter
 * Created by lynnzc on 16-4-16.
 */
public class BannerPagerAdapter extends PagerAdapter {
    //系数, 大于1, 尽量小
    private static final int COEFFIENT = 10;
    private BannerViewPager mViewPager;
    private BannerModel mBannerModel;

    public BannerPagerAdapter(BannerViewPager viewPager, BannerModel bannerModel) {
        this.mViewPager = viewPager;
        this.mBannerModel = bannerModel;
    }

    public BannerPagerAdapter(BannerViewPager viewPager) {
        this(viewPager, null);
    }

    public BannerModel getBannerModel() {
        return mBannerModel;
    }

    public void setBannerModel(BannerModel bannerModel) {
        this.mBannerModel = bannerModel;
    }

    public int getImageCount() {
        return this.mBannerModel == null ? 0 : this.mBannerModel.getImageCount();
    }

    /**
     * 不能重写getCount
     *
     * @return
     */
    @Override
    public final int getCount() {
        long count = getImageCount();
        if (count > 1) {
            //至少大于一张才会轮播
            count = getImageCount() * COEFFIENT;
            count = count > Integer.MAX_VALUE ? Integer.MAX_VALUE : count;
        }
        return (int) count;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public final Object instantiateItem(ViewGroup container, int position) {
        if (mBannerModel == null) {
            return null;
        }

        position = position % mBannerModel.getImageCount();
        //init image
        ImageView bannerView = new ImageView(mViewPager.getContext());
        bannerView.setBackgroundResource(mBannerModel.getImageAt(position));
        container.addView(bannerView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        //init dot
        View dot = new View(mViewPager.getContext());
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                5, //px
                5);//px
        dot.setBackgroundResource(mBannerModel.getDotAt(position));
        dot.setLayoutParams(params);
        //默认第一个为true, 其他false
        dot.setEnabled(position == 0);
        if (mViewPager.getDotContainer() != null) {
            mViewPager.getDotContainer().addView(dot);
        }
        return bannerView;
    }

    @Override
    public final void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        if (mViewPager.getDotContainer() != null) {
            //清楚dot
            mViewPager.getDotContainer().removeViewAt(position);
        }
    }

    @Override
    public final void finishUpdate(ViewGroup container) {
        if (getCount() < 1) {
            //不会替换
            return;
        }

        int position = mViewPager.getCurrentItem();
        if (position == 0) {
            position = mBannerModel.getImageCount();
        } else if (position == getCount() - 1) {
            //最后一张图片
            position = mBannerModel.getImageCount() - 1;
        }
        mViewPager.setCurrentItem(position, false);
    }
}
