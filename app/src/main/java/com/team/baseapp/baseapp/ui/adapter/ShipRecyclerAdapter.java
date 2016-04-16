package com.team.baseapp.baseapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.entity.Good;
import com.team.baseapp.baseapp.model.CartModel;

/**
 * 购物车页面 recyclerview adapter
 * Created by lynnzc on 16-4-16.
 */
public class ShipRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private CartModel ship;

    public ShipRecyclerAdapter(Context context, CartModel ship) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.ship = ship;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ShipGoodViewHolder(context, layoutInflater.inflate(R.layout.item_ship, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ShipGoodViewHolder) {
            ((ShipGoodViewHolder) holder).refresh(ship.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return ship == null ? 0 : ship.size();
    }

    public class ShipGoodViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private TextView tv_title;
        private TextView tv_price;
        private TextView tv_count;
        private ImageView iv_icon;

        public ShipGoodViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            initView(itemView);
        }

        private void initView(View v) {
            tv_title = (TextView) v.findViewById(R.id.tv_title);
            tv_price = (TextView) v.findViewById(R.id.tv_price);
            tv_count = (TextView) v.findViewById(R.id.tv_count);
            iv_icon = (ImageView) v.findViewById(R.id.iv_icon);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    toGoodDetailActivity();
                }
            });
        }

        //刷新数据
        public void refresh(Good good) {
            if (good == null) {
                return;
            }
            tv_title.setText(good.getName());
            tv_price.setText(
                    context.getResources().getString(
                            R.string.one_price, good.getPrice()));
            tv_count.setText(good.getCount());
            //图片资源
//            iv_icon.setImageResource(good.getImage().getImages().get(0));
        }

        private void toGoodDetailActivity() {
            //TODO 跳转商品详情
//            context.startActivity(new Intent(context, GoodDetailActivity.class));
        }
    }
}
