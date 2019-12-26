package com.example.myapplication;

import com.example.myapplication.ui.model.Filme;
import com.example.myapplication.ui.model.FilmeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {

    String api_key = "bdbf476b6e3fc4176cd5ce9e9c901425";

    @GET("trending/movie/week")
    Call<FilmeResponse> getPopulares(@Query("api_key") String api);

    @GET("movie/{id}")
    Call<Filme> getFilmeId(@Path("id") String id, @Query("api_key") String api);

    @GET("search/movie")
    Call<FilmeResponse> getPesquisa(@Query("api_key") String api, @Query("query") String nome, @Query("page") String pagina);
}
