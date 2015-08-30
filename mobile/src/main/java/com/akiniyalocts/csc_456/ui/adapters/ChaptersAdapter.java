package com.akiniyalocts.csc_456.ui.adapters;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.akiniyalocts.csc_456.R;
import com.akiniyalocts.csc_456.model.pojos.Chapter;
import com.akiniyalocts.csc_456.model.pojos.RealmString;

import java.util.List;

import butterknife.Bind;

/**
 * Created by anthony on 8/20/15.
 */
public class ChaptersAdapter extends BaseAdapter<Chapter, ChaptersAdapter.ChapterViewHolder> {

    private int colorRed;

    private int colorBlue;

    private int colorGreen;

    public ChaptersAdapter(List<Chapter> mList, Context mContext) {
        super(mList, mContext);

        colorRed = mContext.getResources().getColor(R.color.accent);
        colorBlue = mContext.getResources().getColor(R.color.primary);
        colorGreen = mContext.getResources().getColor(R.color.accent_green);
    }

    @Override
    public ChapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.chapters_item, parent, false);
        return new ChapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChapterViewHolder holder, int position) {
        Chapter chapter = mList.get(position);

        String topics = "";

        String readings = "";

        String slides = "";

        for(RealmString topic: chapter.getTopics())
            topics += topic.getStringValue() + "\n";

        for(RealmString reading: chapter.getReadings())
            readings += reading.getStringValue() + "\n";

        for(RealmString slide: chapter.getSlides())
            slides += "<a href=" + "\"API.SLIDES_HOST" + slide.getStringValue()  + "\">" +
                    slide.getStringValue().substring(slide.getStringValue().lastIndexOf("/") + 1)
                    + "</a><br><br>" ;

        holder.mTopic.setText(topics);
        holder.mReading.setText(readings);
        holder.mDate.setText(chapter.getDate());
        holder.mSlides.setText(Html.fromHtml(slides));

        if(chapter.isNo_class())
            holder.mHeader.setBackgroundColor(colorGreen);
        else if(chapter.isBoss_fight())
            holder.mHeader.setBackgroundColor(colorRed);
        else
            holder.mHeader.setBackgroundColor(colorBlue);

    }

    public class ChapterViewHolder extends BaseAdapter.BaseViewHolder{

        @Bind(R.id.chapter_date)
        TextView mDate;

        @Bind(R.id.chapter_reading)
        TextView mReading;

        @Bind(R.id.chapter_topic)
        TextView mTopic;

        @Bind(R.id.chapter_slides)
        TextView mSlides;

        @Bind(R.id.date_header)
        FrameLayout mHeader;


        public ChapterViewHolder(View itemView) {
            super(itemView);
            mSlides.setLinksClickable(true);
        }
    }
}
