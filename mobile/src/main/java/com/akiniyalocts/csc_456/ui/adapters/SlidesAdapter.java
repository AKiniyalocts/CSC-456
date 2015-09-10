package com.akiniyalocts.csc_456.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akiniyalocts.csc_456.R;
import com.akiniyalocts.csc_456.model.pojos.RealmString;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by anthony on 9/8/15.
 */
public class SlidesAdapter extends BaseAdapter<RealmString, SlidesAdapter.SlideViewHolder> {

    public SlidesAdapter(List<RealmString> mList, Context mContext) {
        super(mList, mContext);
    }

    @Override
    public SlideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.slides_item, parent, false);
        return new SlideViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SlideViewHolder holder, int position) {
        holder.mLink.setText(mList.get(position).getStringValue());

    }

    public class SlideViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.slide_link)
        TextView mLink;
        public SlideViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
