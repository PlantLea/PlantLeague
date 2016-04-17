package com.team.baseapp.baseapp.ui.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.entity.Menu;
import com.team.baseapp.baseapp.model.UserModel;
import com.team.baseapp.baseapp.ui.adapter.MeRecyclerAdapter;
import com.team.baseapp.baseapp.ui.base.BaseFragment;
import com.team.baseapp.baseapp.ui.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * 我 fragment
 * Created by lynnzc on 16-4-15.
 */
public class MeFragment extends BaseFragment
        implements View.OnClickListener {
    private RecyclerView rv_me;
    private ImageView iv_avatar;
    private TextView tv_nickname;
    private TextView tv_des;
    private MeRecyclerAdapter mAdapter;
    private List<Menu> menus;

    //title
    private String[] titles = new String[]{
            "发布",
            "售出",
            "到手",
            "收藏",
            "设置"
    };

    //icon
    private int[] iconRes = new int[]{
            R.drawable.ic_publish_menu,
            R.drawable.ic_sold_menu,
            R.drawable.ic_buy_menu,
            R.drawable.ic_bookmark_menu,
            R.drawable.ic_setting_menu
    };

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView(View root) {
        tv_des = (TextView) root.findViewById(R.id.tv_des);
        tv_nickname = (TextView) root.findViewById(R.id.tv_nickname);
        iv_avatar = (ImageView) root.findViewById(R.id.iv_avatar);
        initMeRecyclerView(root);
    }

    @Override
    protected void initListener() {
        iv_avatar.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        initMenus();
        initInfo();
        mAdapter = new MeRecyclerAdapter(getContext(), menus);
        rv_me.setAdapter(mAdapter);
    }

    @Override
    public void initHeaderView(@NonNull View header) {
        TextView tv_title = (TextView) header.findViewById(R.id.tv_title);
        tv_title.setText("我的");
    }

    @Override
    public int getHeaderRes() {
        //返回 < 0 则不实现
        return R.layout.include_header;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_avatar:
                toEditUserActivity();
                break;
            default:
                break;
        }
    }

    /**
     * 初始化recyclerview
     *
     * @param root
     */
    private void initMeRecyclerView(View root) {
        rv_me = (RecyclerView) root.findViewById(R.id.rv_me);
        rv_me.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_me.addItemDecoration(
                new DividerItemDecoration(
                        getContext().getResources().getDrawable(R.drawable.default_divider)
                        , false, true));
    }

    /**
     * 初始化menu
     */
    private void initMenus() {
        menus = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            Menu menu = new Menu(titles[i], iconRes[i]);
            menus.add(menu);
        }
    }

    /**
     * 初始化用户个人状态信息
     */
    private void initInfo() {
        if (UserModel.getInstance().isLogin()) {
            //登录成功, 刷新个人信息
            tv_nickname.setText(UserModel.getInstance().getNickname());
            tv_des.setText(UserModel.getInstance().getDescription());
            iv_avatar.setImageResource(UserModel.getInstance().getAvatar());
        }
    }

    /**
     * 跳转到用户信息页面
     */
    private void toEditUserActivity() {
        //TODO
//        getContext().startActivity(new Intent(getContext(), EditUserActivity.class));
    }
}
