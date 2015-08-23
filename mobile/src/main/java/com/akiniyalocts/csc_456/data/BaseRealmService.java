package com.akiniyalocts.csc_456.data;

import android.app.IntentService;
import android.content.Intent;

import com.akiniyalocts.commons.logging.aLog;
import com.akiniyalocts.csc_456.CSCApplication;
import com.akiniyalocts.csc_456.model.OttoWrapper;
import com.squareup.otto.Bus;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public abstract class BaseRealmService<T> extends IntentService implements Callback<List<T>> {
    private static final String TAG = BaseRealmService.class.getSimpleName();

    public static final String ONLINE_KEY = "key::online";

    public abstract void initRealmManager();

    public abstract void doNetworkedTask();

    /**
     * Set intent params if needed. Happens before Network Task and Offline select.
     */
    public abstract void setParams();

    public BaseRealmService() {
        super("BaseRealmService");
    }

    @Override
    public void success(List<T> ts, Response response) {

    }

    @Override
    public void failure(RetrofitError error) {
        aLog.w(TAG, error.getMessage());
        postEvent();
    }

    public Intent intent;

    protected RealmManager realmManager;

    public Bus getBus(){
        return CSCApplication.getBus();
    }

    @Override protected void onHandleIntent(Intent intent) {
        this.intent = intent;

        initRealmManager();

        setParams();

        if(intent.getBooleanExtra(ONLINE_KEY, true))
            doNetworkedTask();
        else
            doOfflineSelect();

    }


    public List<T> doOfflineSelect(){
        return realmManager.select();
    }

    public void postEvent(){
        OttoWrapper<T> wrappedItems = new OttoWrapper<>();
        wrappedItems.setItems(doOfflineSelect());
        getBus().post(wrappedItems);
    }

}


