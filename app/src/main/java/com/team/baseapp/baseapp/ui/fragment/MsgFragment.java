package com.team.baseapp.baseapp.ui.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.entity.Msg;
import com.team.baseapp.baseapp.ui.adapter.MsgRecyclerAdapter;
import com.team.baseapp.baseapp.ui.base.BaseFragment;
import com.team.baseapp.baseapp.ui.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息 fragment
 * Created by lynnzc on 16-4-15.
 */
public class MsgFragment extends BaseFragment {
    private RecyclerView rv_msg;
    private List<Msg> msgs;
    private MsgRecyclerAdapter mAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_msg;
    }

    @Override
    protected void initView(View root) {
        initRecyclerView(root);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        msgs = new ArrayList<>();
        mAdapter = new MsgRecyclerAdapter(getContext(), msgs);
        rv_msg.setAdapter(mAdapter);

        initSystemMsgItem();
        refreshMsg();
    }

    @Override
    protected void initHeaderView(@NonNull View header) {
        TextView tv_title = (TextView) header.findViewById(R.id.tv_title);
        tv_title.setText("消息");
    }

    @Override
    public int getHeaderRes() {
        return R.layout.include_header;
    }

    private void initRecyclerView(View root) {
        rv_msg = (RecyclerView) root.findViewById(R.id.rv_msg);
        rv_msg.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_msg.addItemDecoration(
                new DividerItemDecoration(
                        getResources().getDrawable(R.drawable.default_divider)
                        , false, true));
    }

    private void refreshMsg() {
        //TODO 刷新消息
    }

    /**
     * 初始化系统窗口和订单信息
     */
    private void initSystemMsgItem() {
        Msg msg = new Msg();
        msg.setTitle("系统消息");
        msg.setContent("暂时没有系统消息");
        msg.setImage(R.drawable.ic_system);
        Msg orderMsg = new Msg();
        orderMsg.setTitle("订单信息");
        orderMsg.setContent("暂时没有订单信息");
        orderMsg.setImage(R.drawable.ic_order);

        msgs.add(msg);
        msgs.add(orderMsg);
        mAdapter.notifyDataSetChanged();
    }
}
