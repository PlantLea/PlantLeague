package com.team.baseapp.baseapp.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.team.baseapp.baseapp.model.ImageModel;
import com.team.baseapp.baseapp.ui.widget.BannerViewPager;

/**
 * 轮播adapter
 * Created by lynnzc on 16-4-16.
 */
public class BannerPagerAdapter extends PagerAdapter {
    //系数, 大于1, 尽量小
    private static final int COEFFIENT = 10;
    private BannerViewPager mViewPager;
    private ImageModel mImageModel;

    public BannerPagerAdapter(BannerViewPager viewPager, ImageModel imageModel) {
        this.mViewPager = viewPager;
        this.mImageModel = imageModel;
    }

    public BannerPagerAdapter(BannerViewPager viewPager) {
        this(viewPager, null);
    }

    public void setImageModel(ImageModel imageModel) {
        this.mImageModel = imageModel;
    }

    public ImageModel getImageModel() {
        return mImageModel;
    }

    /**
     * 不能重写getCount
     *
     * @return
     */
    @Override
    public final int getCount() {
        if (mImageModel == null) {
            return 0;
        }

        long count = mImageModel.getImageCount();
        if (count > 1) {
            //至少大于一张才会轮播
            count = mImageModel.getImageCount() * COEFFIENT;
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
        if (mImageModel == null) {
            return null;
        }

        position = position % mImageModel.getImageCount();
        ImageView bannerView = new ImageView(mViewPager.getContext());
        bannerView.setBackgroundResource(mImageModel.getImageAt(position));
        container.addView(bannerView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        return bannerView;
    }

    @Override
    public final void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public final void finishUpdate(ViewGroup container) {
        if (getCount() < 1) {
            //不会替换
            return;
        }

        int position = mViewPager.getCurrentItem();
        if (position == 0) {
            position = mImageModel.getImageCount();
        } else if (position == getCount() - 1) {
            //最后一张图片
            position = mImageModel.getImageCount() - 1;
        }
        mViewPager.setCurrentItem(position, false);
    }
}
