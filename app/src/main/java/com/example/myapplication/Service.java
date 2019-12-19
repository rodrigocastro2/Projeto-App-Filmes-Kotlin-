package com.example.myapplication;

import com.example.myapplication.ui.model.Filme;
import com.example.myapplication.ui.model.FilmeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {

    String api_key = "?api_key=bdbf476b6e3fc4176cd5ce9e9c901425";

    @GET("trending/movie/week" + api_key)
    Call<FilmeResponse> getPopulares();

    @GET("movie/{id}"+ api_key)
    Call<Filme> getFilmeId(@Path("id") String id);
}
