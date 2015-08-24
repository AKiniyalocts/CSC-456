package com.akiniyalocts.csc_456;

import android.app.Application;

import com.akiniyalocts.commons.BaseApplication;
import com.akiniyalocts.commons.logging.aLog;
import com.akiniyalocts.csc_456.model.API;
import com.akiniyalocts.csc_456.model.RealmStringDeserializer;
import com.akiniyalocts.csc_456.model.pojos.RealmString;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.squareup.otto.Bus;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmMigration;
import io.realm.RealmObject;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by anthony on 8/20/15.
 */
public class CSCApplication extends BaseApplication {

    private static RestAdapter restAdapter;

    public static API api;

    private static Bus bus;

    private static Gson gson;

    @Override
    public void onCreate() {
        super.onCreate();
        aLog.setLogging(true);
        getApi();
    }


    public static Gson getGson(){
        if(gson != null){
            return gson;
        }
        else {
            gson = new Gson();
            return gson;
        }
    }

    public static Bus getBus(){
        if(bus != null)
            return bus;
        else{
            bus = new Bus();

            return bus;
        }
    }

    public static RestAdapter getRestAdapter(){
        if(restAdapter != null){
            return restAdapter;
        }
        else {
            Gson gson = new GsonBuilder()
                    .setExclusionStrategies(new ExclusionStrategy() {
                        @Override
                        public boolean shouldSkipField(FieldAttributes f) {
                            return f.getDeclaringClass().equals(RealmObject.class);
                        }

                        @Override
                        public boolean shouldSkipClass(Class<?> clazz) {
                            return false;
                        }
                    }).registerTypeAdapter(new TypeToken<RealmList<RealmString>>() {
                    }.getType(), new RealmStringDeserializer())
                    .create();

            restAdapter = new RestAdapter.Builder()
                    .setEndpoint(API.HOST)
                    .setConverter(new GsonConverter(gson))
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();

            return restAdapter;
        }
    }

    public static API getApi(){
        if(api != null){
            return api;
        }

        else{
            api = getRestAdapter().create(API.class);
            return api;
        }
    }

}
