package com.example.github_app.service;


import com.example.github_app.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface gitHubService {

    @GET("users/{userName}")
    Call <User> getUser(@Path("userName") String userName);

    @GET("users/{userName}/followers")
    Call <List<User>> getFollowers(@Path("userName") String userName);


}
