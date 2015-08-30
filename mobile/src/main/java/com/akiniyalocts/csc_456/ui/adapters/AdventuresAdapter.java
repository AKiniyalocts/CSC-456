package com.akiniyalocts.csc_456.ui.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.akiniyalocts.csc_456.R;
import com.akiniyalocts.csc_456.model.pojos.Adventure;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by anthony on 8/22/15.
 */
public class AdventuresAdapter extends BaseAdapter<Adventure, AdventuresAdapter.AdventureViewHolder> {

    private AdventureClickListener mClickListener;

    public AdventuresAdapter(List<Adventure> mList, Context mContext, AdventureClickListener adventureClickListener ) {
        super(mList, mContext);
        mClickListener = adventureClickListener;
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

    public interface AdventureClickListener{
        public void onAdventureClicked(Adventure adventure);
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

        @OnClick(R.id.adventures_parent)
        public void onAdventureClicked(){
            mClickListener.onAdventureClicked(mList.get(getAdapterPosition()));
        }


        public AdventureViewHolder(View itemView) {
            super(itemView);
        }
    }
}
