package com.example.kmj.warmpot_2018stac;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

interface NetworkInterface {
    @POST("/auth/login")
    Call<LoginModel> GETtoken(@Field("id") String id,@Field("password") String password);

    @POST("/auth/register")
    Call<String> Register(@Field("id") String id,@Field("password") String password,@Field("name") String name,@Field("gender") String gender,@Field("auth_type") String type);
}
