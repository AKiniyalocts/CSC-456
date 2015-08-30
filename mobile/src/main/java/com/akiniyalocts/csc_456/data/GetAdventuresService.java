package com.akiniyalocts.csc_456.data;

import com.akiniyalocts.csc_456.CSCApplication;
import com.akiniyalocts.csc_456.model.pojos.Adventure;
import com.akiniyalocts.csc_456.ui.fragments.ListFragment;

import java.util.List;

import retrofit.client.Response;

/**
 * Created by anthony on 8/22/15.
 */
public class GetAdventuresService extends BaseRealmService<Adventure> {

    private static final String TAG = GetAdventuresService.class.getSimpleName();

    public GetAdventuresService() {
        super();
    }

    @Override
    public int getOttoType() {
        return ListFragment.TYPE_ADVENTURES;
    }

    @Override
    public void success(List<Adventure> adventures, Response response) {
        realmManager.updateMultiple(adventures);
        postEvent();
    }

    @Override
    public void initRealmManager() {
        realmManager = new RealmManager(this, Adventure.class);
    }

    @Override
    public void doNetworkedTask() {
        CSCApplication.getApi().getAdventures(this);
    }

    @Override
    public void setParams() {

    }
}
