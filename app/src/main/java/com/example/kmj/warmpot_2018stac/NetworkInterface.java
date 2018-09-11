package com.example.kmj.warmpot_2018stac;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

interface NetworkInterface {
    @POST("/auth/login")
    @FormUrlEncoded
    Call<LoginModel> GETtoken(@Field("id") String id,@Field("password") String password);

    @POST("/auth/register")
    @FormUrlEncoded
    Call<RegisterModel> Register(@Field("id") String id
            ,@Field("password") String password
            ,@Field("name") String name
            ,@Field("gender") String gender
            ,@Field("auth_type") String type);
}
