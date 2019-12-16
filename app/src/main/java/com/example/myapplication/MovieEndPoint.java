package com.example.myapplication;

import com.example.myapplication.ui.model.Filme;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieEndPoint {

    String api_key = "?api_key=bdbf476b6e3fc4176cd5ce9e9c901425";

    @GET("trending/movie/week" + api_key)
    Call<List<Filme>> populares();




}
