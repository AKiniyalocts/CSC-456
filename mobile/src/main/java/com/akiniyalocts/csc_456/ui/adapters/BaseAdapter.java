package com.akiniyalocts.csc_456.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by anthony on 8/20/15.
 */
public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    public List<T> mList;

    private Context mContext;

    protected LayoutInflater mInflater;

    protected OnItemClickListener onItemClickListener;

    public BaseAdapter(List<T> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
    }



    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



    public interface OnItemClickListener<T> {
        void onItemClick(T item, View rootView);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
    public abstract class BaseViewHolder<VH> extends RecyclerView.ViewHolder{
        public BaseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
