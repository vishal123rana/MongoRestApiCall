package com.example.mongorestapicall;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    @POST("/add")
    Call<Person> createPost(@Body Person person);
}
