package com.team.baseapp.baseapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.model.ImageModel;
import com.team.baseapp.baseapp.util.UIUtils;

/**
 * 添加图片
 * Created by lynnzc on 16-4-20.
 */
public class AddImageRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private ImageModel datas;

    public AddImageRecyclerAdapter(ImageModel datas, Context context) {
        this.datas = datas;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AddImageViewHolder(layoutInflater.inflate(R.layout.item_add_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AddImageViewHolder) {
            ((AddImageViewHolder) holder).refresh(datas.getImageAt(position));
        }
    }

    @Override
    public int getItemCount() {
        return datas.getImageCount();
    }

    private class AddImageViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_add;

        public AddImageViewHolder(View itemView) {
            super(itemView);
            Log.i("AddImageViewHolder", "初始化");
            initView(itemView);
        }

        private void initView(View itemView) {
            if (itemView == null) {
                return;
            }
            iv_add = (ImageView) itemView.findViewById(R.id.iv_add);

            iv_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (datas.getImageCount() - 1 == getAdapterPosition()) {
                        //保证最后一张图片是增加图片按钮, 除非当前已满九张
                        UIUtils.showToast(view.getContext(), "为方便测试, 并未实现从相册获取图片");
                        if (datas.getImageCount() < 9) {
                            /**
                             * 添加图片 add
                             */
                            datas.setResAt(R.drawable.ic_good6, datas.getImageCount() - 1);
                            //添加图片按钮
                            datas.addRes(0);
                            notifyItemRangeChanged(datas.getImageCount() - 2, 2);
                        } else {
                            //覆盖添加按钮
                            datas.setResAt(R.drawable.ic_good6, datas.getImageCount() - 1);
                            notifyItemChanged(datas.getImageCount() - 1);
                        }
                    }
                }
            });
        }

        private void refresh(int resId) {
            if (resId == 0) {
                return;
            }

            iv_add.setImageResource(resId);
        }
    }
}
