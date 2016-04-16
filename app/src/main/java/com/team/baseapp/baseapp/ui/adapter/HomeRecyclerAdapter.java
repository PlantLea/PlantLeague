package com.team.baseapp.baseapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

        public BannerViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
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
        }

        /**
         * 刷新数据
         */
        public void refresh() {
            //如果没有初始化成功, 刷新bannermodel
            if (adapter.getBannerModel() == null) {
                adapter.setBannerModel(getBannerModel());
            }

            viewPager.setStatus(BannerViewPager.RESUME);
        }

        private BannerModel getBannerModel() {
            if (getLayoutPosition() == 0) {
                Object data = datas.get(getLayoutPosition());
                if (data instanceof BannerModel) {
                    return ((BannerModel) data);
                }
            }
            return null;
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
