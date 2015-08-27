package com.akiniyalocts.csc_456.ui;

import android.os.Bundle;

import com.akiniyalocts.commons.activities.fragments.ButterKnifeFragment;
import com.akiniyalocts.csc_456.R;
import com.github.lzyzsd.circleprogress.DonutProgress;

import butterknife.Bind;

/**
 * Created by anthony on 8/26/15.
 */
public class OverviewFragment extends ButterKnifeFragment {

    @Bind(R.id.donut_progress)
    DonutProgress mProgress;

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

        mProgress.setProgress(50);

    }
}
