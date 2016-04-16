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
import com.team.baseapp.baseapp.entity.Msg;
import com.team.baseapp.baseapp.ui.activity.MainActivity;

import java.util.List;

/**
 * msg recyclerview adapter
 * Created by lynnzc on 16-4-16.
 */
public class MsgRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<Msg> msgs;

    public MsgRecyclerAdapter(Context context, List<Msg> msgs) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.msgs = msgs;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MsgViewHolder(context, layoutInflater.inflate(R.layout.item_msg, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MsgViewHolder) {
            ((MsgViewHolder) holder).refresh(msgs.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return msgs == null ? 0 : msgs.size();
    }

    public static class MsgViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private TextView tv_title;
        private TextView tv_content;
        private ImageView iv_icon;

        public MsgViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            initView(itemView);
        }

        private void initView(View v) {
            tv_title = (TextView) v.findViewById(R.id.tv_title);
            tv_content = (TextView) v.findViewById(R.id.tv_content);
            iv_icon = (ImageView) v.findViewById(R.id.iv_icon);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (getLayoutPosition()) {
                        case 0:
                            //系统消息
                            toSystemMsgActivity();
                            break;
                        case 1:
                            //订单消息
                            toOrderMsgActivity();
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
        public void refresh(Msg msg) {
            tv_title.setText(msg.getTitle());
            tv_content.setText(msg.getContent());
        }

        private void toSystemMsgActivity() {
            //TODO 跳转到系统消息
            context.startActivity(new Intent(context, MainActivity.class));
        }

        private void toOrderMsgActivity() {
            //TODO 跳转到订单消息界面
            context.startActivity(new Intent(context, MainActivity.class));
        }
    }
}
