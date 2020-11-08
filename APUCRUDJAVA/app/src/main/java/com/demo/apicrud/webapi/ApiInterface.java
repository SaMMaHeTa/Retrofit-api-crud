package com.demo.apicrud.webapi;


import com.demo.apicrud.Models.GetUserDetails.ResponseUserDetail;
import com.demo.apicrud.Models.GetUsers.ResponseUsers;
import com.demo.apicrud.Models.ResponseCommon;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface ApiInterface {


    @GET("demos")
    Call<ResponseUsers> getUsers();


    @GET("")
    Call<ResponseUserDetail> getUserDetails(@Url String url);

    @FormUrlEncoded
    @POST("")
    Call<ResponseCommon> updateUser(
            @Url String url,
            @Field("name") String name,
            @Field("contact") String contact,
            @Field("city") String city
    );

    @FormUrlEncoded
    @POST("demos/store")
    Call<ResponseCommon> addUser(@Field("name") String name,
                                 @Field("contact") String contact,
                                 @Field("city") String city
    );

    @FormUrlEncoded
    @POST("")
    Call<ResponseCommon> deleteUser(
            @Url String url,
            @Field("__method") String method
    );
}