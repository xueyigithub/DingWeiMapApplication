package com.app.xueyi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amap.api.services.core.PoiItem;
import com.app.xueyi.dingweimapapplication.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PoiSearchAdapter extends RecyclerView.Adapter<PoiSearchAdapter.ViewHolder> {

    /**
     * ItemClick的回调接口
     *
     * @author zhy
     */
    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


    private List<PoiItem> mDataset;
    private Context context;

    public PoiSearchAdapter(List<PoiItem> dataset, Context context) {
        super();
        this.context = context;
        mDataset = dataset;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.poi_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        PoiItem poiItem=mDataset.get(i);

        viewHolder.poi.setText(poiItem.getTitle());
        viewHolder.address.setText(poiItem.getSnippet());
        viewHolder.tel.setText(poiItem.getTel());


        //如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(viewHolder.itemView, i);

                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_poi)
        TextView poi;

        @Bind(R.id.tv_address)
        TextView address;

        @Bind(R.id.tv_tel)
        TextView tel;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
