package com.akiniyalocts.csc_456.ui.fragments;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.akiniyalocts.commons.activities.fragments.ButterKnifeFragment;
import com.akiniyalocts.csc_456.R;
import com.akiniyalocts.csc_456.Utils;
import com.akiniyalocts.csc_456.data.RealmManager;
import com.akiniyalocts.csc_456.model.pojos.Chapter;

import java.util.Date;
import java.util.List;

import butterknife.Bind;

/**
 * Created by anthony on 8/26/15.
 */
public class OverviewFragment extends ButterKnifeFragment {

    private final static String TAG = OverviewFragment.class.getSimpleName();

    @Bind(R.id.circle_progress)
    ProgressBar mProgress;

    @Bind(R.id.progress_text)
    TextView mProgressText;

    public static OverviewFragment newInstance() {

        Bundle args = new Bundle();

        OverviewFragment fragment = new OverviewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_overview;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initProgress();

    }

    private void initProgress(){

        RealmManager<Chapter> realmManager = new RealmManager<>(getActivity(), Chapter.class);

        List<Chapter> chapters = realmManager.select();

        Date[] dates = new Date[chapters.size()];

        for(int i= 0; i <= dates.length - 1; i++){
            dates[i] = Utils.getDateFromString(chapters.get(i).getDate() + "/15");
        }

      
        ObjectAnimator animation = ObjectAnimator.ofInt (mProgress, "progress", 1, chapters.size());
        animation.setDuration (5000); //in milliseconds
        animation.setInterpolator (new DecelerateInterpolator());
        animation.start();
    }
}
