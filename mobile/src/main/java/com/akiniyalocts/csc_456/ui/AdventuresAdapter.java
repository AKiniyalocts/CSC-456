package com.akiniyalocts.csc_456.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.akiniyalocts.csc_456.R;
import com.akiniyalocts.csc_456.model.pojos.Adventure;

import java.util.List;

import butterknife.Bind;

/**
 * Created by anthony on 8/22/15.
 */
public class AdventuresAdapter extends BaseAdapter<Adventure, AdventuresAdapter.AdventureViewHolder> {

    public AdventuresAdapter(List<Adventure> mList, Context mContext) {
        super(mList, mContext);
    }

    @Override
    public void onBindViewHolder(AdventureViewHolder holder, int position) {
        Adventure adventure = mList.get(position);

        holder.mTitle.setText(adventure.getTitle());
        holder.mOverview.setText(adventure.getOverview());
        holder.mDate.setText(adventure.getDate());
        holder.mXp.setText(adventure.getXp());
    }

    @Override
    public AdventureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.adventures_item, parent, false);

        return new AdventureViewHolder(itemView);
    }

    public class AdventureViewHolder extends BaseAdapter.BaseViewHolder{

        @Bind(R.id.adventure_title)
        TextView mTitle;

        @Bind(R.id.adventure_overview)
        TextView mOverview;

        @Bind(R.id.adventure_date)
        TextView mDate;

        @Bind(R.id.adventure_xp)
        TextView mXp;

        @Bind(R.id.title_wrapper)
        FrameLayout mWrapper;

        public AdventureViewHolder(View itemView) {
            super(itemView);
        }
    }
}
