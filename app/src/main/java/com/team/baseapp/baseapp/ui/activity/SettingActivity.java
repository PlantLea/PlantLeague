package com.team.baseapp.baseapp.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.entity.Menu;
import com.team.baseapp.baseapp.ui.adapter.SettingRecyclerAdapter;
import com.team.baseapp.baseapp.ui.base.BaseActivity;
import com.team.baseapp.baseapp.ui.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * 设置　activity
 * Created by lynnzc on 16-4-17.
 */
public class SettingActivity extends BaseActivity
        implements View.OnClickListener {
    private RecyclerView rv_setting;
    private ImageView iv_left;
    private TextView tv_title;
    private TextView tv_quit;
    private List<Menu> data;

    private SettingRecyclerAdapter mAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {
        initHeader();
        initSettingRecycler();
        tv_quit = (TextView) findViewById(R.id.tv_quit);
    }

    @Override
    protected void initListener() {
        tv_quit.setOnClickListener(this);
        iv_left.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        data = new ArrayList<>();

        data.add(new Menu("个人信息"));
        data.add(new Menu("消息设置"));
        data.add(new Menu("分享给朋友"));
        data.add(new Menu("清楚缓存"));
        data.add(new Menu("关于我们"));
        data.add(new Menu("帮助与反馈"));
        data.add(new Menu("检测新版本"));

        mAdapter = new SettingRecyclerAdapter(this, data);
        rv_setting.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                onBackClicked();
                break;
            case R.id.tv_quit:
                onQuitClicked();
                break;
            default:
                break;
        }
    }

    /**
     * 初始化header
     */
    private void initHeader() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_left = (ImageView) findViewById(R.id.iv_left);

        iv_left.setVisibility(View.VISIBLE);
        iv_left.setImageResource(R.drawable.ic_left_arrow);
        tv_title.setText("设置");
    }

    private void initSettingRecycler() {
        rv_setting = (RecyclerView) findViewById(R.id.rv_setting);
        rv_setting.setLayoutManager(new LinearLayoutManager(this));
        rv_setting.addItemDecoration(new DividerItemDecoration(
                getResources().getDrawable(R.drawable.default_divider),
                false, true));
    }

    /**
     * 返回
     */
    private void onBackClicked() {
        finish();
    }

    /**
     * 退出登录
     */
    private void onQuitClicked() {
        //TODO 退出登录
    }
}
