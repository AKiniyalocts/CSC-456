package com.akiniyalocts.csc_456.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.akiniyalocts.commons.activities.fragments.ButterKnifeFragment;
import com.akiniyalocts.csc_456.CSCApplication;
import com.akiniyalocts.csc_456.R;
import com.akiniyalocts.csc_456.data.GetAdventuresService;
import com.akiniyalocts.csc_456.data.GetBadgesService;
import com.akiniyalocts.csc_456.data.GetChaptersService;
import com.akiniyalocts.csc_456.model.OttoResult;
import com.akiniyalocts.csc_456.model.pojos.Badge;
import com.akiniyalocts.csc_456.ui.adapters.AdventuresAdapter;
import com.akiniyalocts.csc_456.ui.adapters.BadgesAdapter;
import com.akiniyalocts.csc_456.ui.adapters.BaseAdapter;
import com.akiniyalocts.csc_456.ui.adapters.ChaptersAdapter;
import com.squareup.otto.Subscribe;

import butterknife.Bind;

/**
 * Created by anthony on 8/20/15.
 */
public class ListFragment extends ButterKnifeFragment implements SwipeRefreshLayout.OnRefreshListener{

    public final static String KEY_CONTENT = "key::content";

    public final static int TYPE_CHAPTERS = 100;

    public final static int TYPE_ADVENTURES = 101;

    public final static int TYPE_BADGES = 102;

    public static ListFragment newInstance(int type){
        ListFragment listFragment = new ListFragment();
        Bundle bundle = new Bundle();

        bundle.putInt(KEY_CONTENT, type);

        listFragment.setArguments(bundle);

        return listFragment;
    }

    private final static String TAG = ListFragment.class.getSimpleName();


    @Bind(R.id.chapters_recycler)
    RecyclerView mRecycler;

    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout mRefresh;

    private ChaptersAdapter chaptersAdapter;
    private int type;

    @Override
    public int getContentView() {
        return R.layout.fragment_list;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        CSCApplication.getBus().register(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        CSCApplication.getBus().unregister(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecycler();

        mRefresh.setOnRefreshListener(this);
        mRefresh.setColorSchemeResources(R.color.accent_green, R.color.primary);

        if(getArguments() != null) {
            type = getArguments().getInt(KEY_CONTENT, -1);

            startServiceForType(type);
        }
        else
            getActivity().startService(new Intent(getActivity(), GetChaptersService.class));
    }

    @Override
    public void onRefresh() {
        startServiceForType(type);
    }

    @Subscribe
    public void onOttoResult(OttoResult ottoResult){

        mRefresh.setRefreshing(false);
        mRecycler.setAdapter(null);
        mRecycler.setLayoutManager(new StaggeredGridLayoutManager(getNumColumns(), StaggeredGridLayoutManager.VERTICAL));

        switch (ottoResult.getType()){


            case TYPE_ADVENTURES:
                mRecycler.setAdapter(new AdventuresAdapter(ottoResult.getItems(), getActivity(), ((AdventuresAdapter.AdventureClickListener)getActivity())));
                break;

            case TYPE_CHAPTERS:
                chaptersAdapter = new ChaptersAdapter(ottoResult.getItems(), getActivity());
                mRecycler.setAdapter(chaptersAdapter);
                break;

            case TYPE_BADGES:
                mRecycler.setAdapter(new BadgesAdapter(ottoResult.getItems(), getActivity(), ((BaseAdapter.OnItemClickListener<Badge>) getActivity())));
                break;
        }

    }

    private void startServiceForType(int type){
        switch (type){
            case TYPE_ADVENTURES:
                getActivity().startService(new Intent(getActivity(), GetAdventuresService.class));

                break;
            case TYPE_BADGES:
                getActivity().startService(new Intent(getActivity(), GetBadgesService.class));
                break;

            default:
                getActivity().startService(new Intent(getActivity(), GetChaptersService.class));
                break;

        }
    }
    private void initRecycler(){
        mRecycler.setLayoutManager(new StaggeredGridLayoutManager(getNumColumns(), StaggeredGridLayoutManager.VERTICAL));
    }
    private int getNumColumns(){
        if(CSCApplication.isTablet())
            return 3;
        else
            return 2;
    }
}
