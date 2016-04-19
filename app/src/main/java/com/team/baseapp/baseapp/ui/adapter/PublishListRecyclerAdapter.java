package com.team.baseapp.baseapp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.baseapp.baseapp.Constants;
import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.entity.Good;
import com.team.baseapp.baseapp.entity.Menu;
import com.team.baseapp.baseapp.ui.activity.GoodDetailActivity;
import com.team.baseapp.baseapp.ui.activity.PublishListActivity;
import com.team.baseapp.baseapp.ui.activity.SettingActivity;

import java.util.List;

/**
 * Created by lynnzc on 16-4-19.
 */
public class PublishListRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements IListAdapter<Good> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<Good> datas;

    public PublishListRecyclerAdapter(Context context, List<Good> datas) {
        this.context = context;
        this.datas = datas;

        layoutInflater = LayoutInflater.from(context);
    }

    public void setDatas(List<Good> datas) {
        this.datas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MeMenuViewHolder(context, layoutInflater.inflate(R.layout.item_public_list, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MeMenuViewHolder) {
            ((MeMenuViewHolder) holder).refresh(datas.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public void add(Good data) {
        datas.add((Good) data);
    }

    @Override
    public void addAll(List<Good> datas) {
        datas.addAll(datas);
    }

    @Override
    public void clear() {
        datas.clear();
    }

    public class MeMenuViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private TextView tv_title;
        private TextView tv_price;

        public MeMenuViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            initView(itemView);
        }

        private void initView(View v) {
            tv_title = (TextView) v.findViewById(R.id.tv_title);
            tv_price = (TextView) v.findViewById(R.id.tv_price);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //跳转到 商品详情
                    view.getContext().startActivity(
                            new Intent(view.getContext(), GoodDetailActivity.class)
                                    .putExtra(Constants.PARAM_GOOD_DATA, datas.get(getAdapterPosition())));
                }
            });
        }

        //刷新数据
        public void refresh(Good good) {
            tv_title.setText(good.getName());
            tv_price.setText(good.getPrice());
//            iv_icon.setImageResource(good.getCount());
        }

        private void toActivity(Class to) {
            context.startActivity(new Intent(context, to));
        }
    }
}
