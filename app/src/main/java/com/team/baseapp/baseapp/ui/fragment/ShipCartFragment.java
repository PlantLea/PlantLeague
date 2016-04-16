package com.team.baseapp.baseapp.ui.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.model.CartModel;
import com.team.baseapp.baseapp.model.UserModel;
import com.team.baseapp.baseapp.ui.adapter.ShipRecyclerAdapter;
import com.team.baseapp.baseapp.ui.base.BaseFragment;
import com.team.baseapp.baseapp.ui.widget.DividerItemDecoration;

/**
 * 购物车 fragment
 * Created by lynnzc on 16-4-15.
 */
public class ShipCartFragment extends BaseFragment {
    private RecyclerView rv_ship;
    private ShipRecyclerAdapter mAdapter;
    private CartModel ship;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_ship_cart;
    }

    @Override
    protected void initView(View root) {
        initShipRecyclerView(root);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        initCartModel();
        mAdapter = new ShipRecyclerAdapter(getContext(), ship);
        rv_ship.setAdapter(mAdapter);
    }

    @Override
    protected void initHeaderView(@NonNull View header) {
        TextView tv_title = (TextView) header.findViewById(R.id.tv_title);
        tv_title.setText("购物车");
    }

    @Override
    public int getHeaderRes() {
        return R.layout.include_header;
    }

    private void initShipRecyclerView(View root) {
        rv_ship = (RecyclerView) root.findViewById(R.id.rv_ship);
        rv_ship.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_ship.addItemDecoration(
                new DividerItemDecoration(
                        getContext().getResources().getDrawable(R.drawable.default_divider)));
    }

    private void initCartModel() {
        ship = new CartModel(UserModel.getInstance().getUser().getCarts());
    }
}
