package com.akiniyalocts.csc_456.model;

import com.akiniyalocts.csc_456.model.pojos.Adventure;
import com.akiniyalocts.csc_456.model.pojos.Badge;
import com.akiniyalocts.csc_456.model.pojos.Chapter;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by anthony on 8/20/15.
 */
public interface API {

    String HOST = "http://nku.benjamingbaxter.com/csc456/2015fall/app/api";
    String SLIDES_HOST = "http://nku.benjamingbaxter.com/csc456/slides";

    @GET("/chapters-grouped.php")
    void getChapters(Callback<List<Chapter>> chaptersCallback );

    @GET("/badges.php")
    void getBadges(Callback<List<Badge>> badgesCallback);

    @GET("/adventures.php")
    void getAdventures(Callback<List<Adventure>> adventuresCallback);
}
