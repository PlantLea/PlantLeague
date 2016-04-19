package com.team.baseapp.baseapp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.entity.Menu;
import com.team.baseapp.baseapp.util.UIUtils;

import java.util.List;

/**
 * 设置页面 recyclerview adapter
 * Created by lynnzc on 16-4-16.
 */
public class SettingRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<Menu> menus;

    public SettingRecyclerAdapter(Context context, List<Menu> menus) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.menus = menus;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MeMenuViewHolder(context, layoutInflater.inflate(R.layout.item_setting, parent, false));
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

    public class MeMenuViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private TextView tv_title;

        public MeMenuViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            initView(itemView);
        }

        private void initView(View v) {
            tv_title = (TextView) v.findViewById(R.id.tv_title);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (getAdapterPosition()) {
                        default:
                            //其他
                            UIUtils.showToast(view.getContext(), "未实现");
                            break;
                    }
                }
            });
        }

        //刷新数据
        public void refresh(Menu menu) {
            tv_title.setText(menu.getTitle());
        }

        private void toActivity(Class to) {
            context.startActivity(new Intent(context, to));
        }
    }
}
