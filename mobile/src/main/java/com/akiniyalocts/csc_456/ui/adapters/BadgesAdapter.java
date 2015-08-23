package com.akiniyalocts.csc_456.ui.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.akiniyalocts.commons.widgets.MaterialIconTextView;
import com.akiniyalocts.csc_456.R;
import com.akiniyalocts.csc_456.model.BadgeMapper;
import com.akiniyalocts.csc_456.model.Constants;
import com.akiniyalocts.csc_456.model.pojos.Badge;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by anthony on 8/23/15.
 */
public class BadgesAdapter extends BaseAdapter<Badge, BadgesAdapter.BadgeViewHolder> {

    public BadgesAdapter(List<Badge> mList, Context mContext) {
        super(mList, mContext);
    }

    @Override
    public BadgeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.badge_item, parent, false);

        return new BadgeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BadgeViewHolder holder, int position) {

        Badge badge = mList.get(position);

        holder.mGlyph.setText(BadgeMapper.get(badge.getBadge()));
        holder.mTitle.setText(badge.getTitle());
        holder.mFrame.setBackgroundColor(Color.parseColor(Constants.getRandomMaterialColor()));
    }

    public class BadgeViewHolder extends BaseAdapter.BaseViewHolder{

        @Bind(R.id.badge_glyph)
        MaterialIconTextView mGlyph;

        @Bind(R.id.badge_title)
        TextView mTitle;

        @Bind(R.id.badge_bg)
        FrameLayout mFrame;

        @OnClick(R.id.badges_parent)
        public void onBadgeClick(){}

        public BadgeViewHolder(View itemView) {
            super(itemView);
        }
    }
}
