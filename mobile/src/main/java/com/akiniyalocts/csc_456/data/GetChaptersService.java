package com.akiniyalocts.csc_456.data;


import com.akiniyalocts.csc_456.CSCApplication;
import com.akiniyalocts.csc_456.model.pojos.Chapter;
import com.akiniyalocts.csc_456.ui.fragments.ListFragment;

import java.util.List;

import retrofit.client.Response;

public class GetChaptersService extends BaseRealmService<Chapter> {

    private static final String TAG = GetChaptersService.class.getSimpleName();

    public GetChaptersService() {
        super();
    }

    @Override
    public int getOttoType() {
        return ListFragment.TYPE_CHAPTERS;
    }

    @Override
    public void success(List<Chapter> chapters, Response response) {
        realmManager.updateMultiple(chapters);
        postEvent();
    }


    @Override
    public void initRealmManager() {
        realmManager = new RealmManager<Chapter>(getApplicationContext(), Chapter.class);
    }

    @Override
    public void doNetworkedTask() {
        CSCApplication.getApi().getChapters(this);
    }

    @Override
    public void setParams() {

    }

}
