package com.team.baseapp.baseapp.ui.view;

import android.view.View;
import android.view.ViewGroup;

/**
 * header view
 * Created by lynnzc on 16-4-16.
 */
public interface HeaderView {
    View attachHeader(ViewGroup parent);

    void initHeader(View header);

    boolean isHideHeader();

    /**
     * 返回 <= 0 也不显示
     */
    int getHeaderRes();
}
