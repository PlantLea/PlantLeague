package com.team.baseapp.baseapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.model.BannerModel;
import com.team.baseapp.baseapp.ui.widget.BannerViewPager;

import java.util.List;

/**
 * home recycler adapter
 * Created by lynnzc on 16-4-16.
 */
public class HomeRecyclerAdapter
        extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements IListAdapter {
    public static final int ITEM_VIEW_BANNER = 0;
    public static final int ITEM_VIEW_CONTENT = 1;
    private LayoutInflater layoutInflater;
    private List<Object> datas;
    private Context context;

    public HomeRecyclerAdapter(Context context, List<Object> datas) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.datas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_VIEW_BANNER) {
            return new BannerViewHolder(
                    context, layoutInflater.inflate(R.layout.item_banner, parent, false));
        } else if (viewType == ITEM_VIEW_CONTENT) {
            return new ContentViewHolder(
                    context, layoutInflater.inflate(R.layout.item_home_content, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BannerViewHolder) {
            ((BannerViewHolder) holder).refresh();
        } else if (holder instanceof ContentViewHolder) {
            ((ContentViewHolder) holder).refresh();
        }
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return ITEM_VIEW_BANNER;
            default:
                return ITEM_VIEW_CONTENT;
        }
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        if (holder instanceof BannerViewHolder) {
            ((BannerViewHolder) holder).setStatus(BannerViewPager.RESUME);
        }
    }

    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if (holder instanceof BannerViewHolder) {
            ((BannerViewHolder) holder).setStatus(BannerViewPager.DESTROY);
        }
    }

    @Override
    public void addAll(List<Object> datas) {
        this.datas.addAll(datas);
    }

    @Override
    public void add(Object o) {
        this.datas.add(o);
    }

    @Override
    public void clear() {
        this.datas.clear();
    }

    private class BannerViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private BannerViewPager viewPager;
        private BannerPagerAdapter adapter;
        private LinearLayout dotContainer;
        private boolean isDotInit;

        public BannerViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            isDotInit = false;
            init(itemView);
        }

        private void init(View container) {
            if (container == null) {
                return;
            }
            dotContainer = (LinearLayout) container.findViewById(R.id.lly_dot);
            viewPager = (BannerViewPager) container.findViewById(R.id.vp_content);
            viewPager.setDotContainer(dotContainer);
            adapter = new BannerPagerAdapter(viewPager, getBannerModel());
            viewPager.setAdapter(adapter);
            //初始化提示点
            initDot(viewPager, getBannerModel());
            viewPager.setCurrentItem(0);
        }

        /**
         * 刷新数据
         */
        public void refresh() {
            //如果没有初始化成功, 刷新bannermodel
            if (adapter.getBannerModel() == null) {
                adapter.setBannerModel(getBannerModel());
                if (!isDotInit) {
                    //没有初始化, 初始化
                    initDot(viewPager, getBannerModel());
                }
            }

            viewPager.setStatus(BannerViewPager.RESUME);
        }

        private BannerModel getBannerModel() {
            if (getAdapterPosition() == 0) {
                Object data = datas.get(getAdapterPosition());
                if (data instanceof BannerModel) {
                    return ((BannerModel) data);
                }
            }
            return null;
        }

        private void initDot(BannerViewPager viewPager, BannerModel bannerModel) {
            if (viewPager.getDotContainer() == null ||
                    bannerModel == null) {
                return;
            }

            for (int i = 0; i < bannerModel.getImageCount(); i++) {
                //init dot
                View dot = new View(viewPager.getContext());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        10, //px
                        10);//px
                params.setMargins(4, 0, 4, 0);
                dot.setBackgroundResource(bannerModel.getDotAt(i));
                dot.setLayoutParams(params);
                //默认第一个为true, 其他false
                dot.setEnabled(i == 0);
                if (viewPager.getDotContainer() != null) {
                    viewPager.getDotContainer().addView(dot);
                }
            }
            isDotInit = true;
        }

        public void setStatus(@BannerViewPager.Life int status) {
            viewPager.setStatus(status);
        }
    }

    private class ContentViewHolder extends RecyclerView.ViewHolder {
        private Context context;

        public ContentViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            init(itemView);
        }

        private void init(View root) {
            if (root == null) {
                return;
            }
        }

        public void refresh() {

        }
    }
}
