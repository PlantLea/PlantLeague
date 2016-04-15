package com.team.baseapp.baseapp.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.ui.fragment.ExploreFragment;
import com.team.baseapp.baseapp.ui.fragment.HomeFragment;
import com.team.baseapp.baseapp.ui.fragment.MeFragment;
import com.team.baseapp.baseapp.ui.fragment.MsgFragment;

/**
 * bottom bar adapter
 * Created by lynnzc on 16-4-15.
 */
public class BottomBarAdapter extends FragmentPagerAdapter {
    private static final int PAGE_COUNT = 4;
    //tab title
    private String[] tabTitles = new String[]{
            "首页",
            "发现",
            "消息",
            "我的",
    };
    //tab icon
    private int[] tabIcons = new int[]{
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
    };

    private Context context;

    public BottomBarAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
            default:
                //首页
                return new HomeFragment();
            case 2:
                //发现
                return new ExploreFragment();
            case 3:
                //消息
                return new MsgFragment();
            case 4:
                //我的
                return new MeFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    /**
     * TODO 返回 custom tab view
     *
     * @return resId
     */
    public View getCustomTabView(int position) {
        if (position > PAGE_COUNT) {
            //out of bound
            return null;
        }

        View tab = LayoutInflater.from(context).inflate(R.layout.item_tab_view, null);
        TextView tv_tab = (TextView) tab.findViewById(R.id.tv_tab);
        ImageView iv_tab = (ImageView) tab.findViewById(R.id.iv_tab);
        tv_tab.setText(tabTitles[position]);
        iv_tab.setImageResource(tabIcons[position]);
        return tab;
    }
}
