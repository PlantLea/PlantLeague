package com.team.baseapp.baseapp.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.entity.Good;
import com.team.baseapp.baseapp.model.UserModel;
import com.team.baseapp.baseapp.ui.adapter.PublishListRecyclerAdapter;
import com.team.baseapp.baseapp.ui.base.BaseActivity;
import com.team.baseapp.baseapp.ui.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的发布列表 activity
 * Created by lynnzc on 16-4-17.
 */
public class PublishListActivity extends BaseActivity
        implements View.OnClickListener {
    private RecyclerView rv_content;
    private TextView tv_title;
    private ImageView iv_left;
    private ImageView iv_right;
    private List<Good> publishs = new ArrayList<>();
    private PublishListRecyclerAdapter mAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_publish_list;
    }

    @Override
    protected void initView() {
        initHeader();
        initListRecyclerView();
    }

    @Override
    protected void initListener() {
        iv_left.setOnClickListener(this);
        iv_right.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        if (UserModel.getInstance().getRelease() != null) {
            publishs.clear();
            publishs.addAll(UserModel.getInstance().getRelease());
        }
        mAdapter = new PublishListRecyclerAdapter(this, publishs);
        rv_content.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                onBackClicked();
                break;
            case R.id.iv_right:
                //跳转发布界面
                onAddGoodClicked();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        refreshList();
        super.onResume();
    }

    private void initHeader() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_left = (ImageView) findViewById(R.id.iv_left);
        iv_right = (ImageView) findViewById(R.id.iv_right);

        tv_title.setText("我的发布");
        iv_left.setVisibility(View.VISIBLE);
        iv_left.setImageResource(R.drawable.ic_left_arrow);
        iv_right.setVisibility(View.VISIBLE);
        iv_right.setImageResource(R.drawable.ic_add);
    }

    private void initListRecyclerView() {
        rv_content = (RecyclerView) findViewById(R.id.rv_content);
        rv_content.setLayoutManager(new LinearLayoutManager(this));
        rv_content.addItemDecoration(new DividerItemDecoration(
                getResources().getDrawable(R.drawable.default_divider),
                false, true
        ));
    }

    private void onBackClicked() {
        finish();
    }

    private void onAddGoodClicked() {
        //跳转发布界面
        startActivity(new Intent(this, PublishGoodActivity.class));
    }

    private void refreshList() {
        //reenter
        if (rv_content != null && mAdapter != null &&
                UserModel.getInstance().getRelease() != null) {
            publishs.clear();
            publishs.addAll(UserModel.getInstance().getRelease());
            mAdapter.notifyDataSetChanged();
        }
    }
}
