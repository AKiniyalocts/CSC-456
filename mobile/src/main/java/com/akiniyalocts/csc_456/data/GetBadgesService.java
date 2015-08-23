package com.akiniyalocts.csc_456.data;

import com.akiniyalocts.csc_456.CSCApplication;
import com.akiniyalocts.csc_456.model.pojos.Badge;
import com.akiniyalocts.csc_456.ui.ListFragment;

import java.util.List;

import retrofit.client.Response;

/**
 * Created by anthony on 8/22/15.
 */
public class GetBadgesService extends BaseRealmService<Badge> {

    public GetBadgesService() {
        super();
    }

    @Override
    public void success(List<Badge> badges, Response response) {
        realmManager.updateMultiple(badges);
        postEvent();
    }

    @Override
    public void initRealmManager() {
        realmManager = new RealmManager(getApplicationContext(), Badge.class);
    }

    @Override
    public void doNetworkedTask() {
        CSCApplication.getApi().getBadges(this);
    }

    @Override
    public int getOttoType() {
        return ListFragment.TYPE_BADGES;
    }

    @Override
    public void setParams() {

    }
}
