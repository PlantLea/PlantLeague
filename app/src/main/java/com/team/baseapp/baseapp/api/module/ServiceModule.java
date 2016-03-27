package com.team.baseapp.baseapp.api.module;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 具体api module
 * Created by lynnzc on 16-3-20.
 */
public interface ServiceModule {
    /**
     * @GET("/get/example")
     * Call<String> getExample(@Path("path") String path, @Query("query") String query);
     *
     * @FormUrlEncoded
     * @POST("/post/example")
     * Call<String> postExample(@Field("field") String field);
     **/
}
