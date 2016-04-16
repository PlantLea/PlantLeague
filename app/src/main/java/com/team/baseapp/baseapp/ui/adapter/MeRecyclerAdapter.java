package com.team.baseapp.baseapp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.model.MenuModel;

import java.util.List;

/**
 * Created by lynnzc on 16-4-16.
 */
public class MeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<MenuModel> menus;

    public MeRecyclerAdapter(Context context, List<MenuModel> menus) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.menus = menus;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MeMenuViewHolder(context, layoutInflater.inflate(R.layout.item_menu, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MeMenuViewHolder) {
            ((MeMenuViewHolder) holder).refresh(menus.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return menus == null ? 0 : menus.size();
    }

    public static class MeMenuViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private TextView tv_title;
        private ImageView iv_icon;

        public MeMenuViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            initView(itemView);
        }

        private void initView(View v) {
            tv_title = (TextView) v.findViewById(R.id.tv_title);
            iv_icon = (ImageView) v.findViewById(R.id.iv_icon);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (getLayoutPosition()) {
                        case 0:
                            //跳转
                            break;
                        case 1:
                            //跳转
                            break;
                        default:
                            //其他
                            //TODO 其他消息
                            break;
                    }
                }
            });
        }

        //刷新数据
        public void refresh(MenuModel menu) {
            tv_title.setText(menu.getTitle());
        }
    }
}
