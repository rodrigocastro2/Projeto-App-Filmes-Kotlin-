package com.example.myapplication;

import com.example.myapplication.ui.model.Filme;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieEndPoint {

    @GET
    Call<Filme> teste();
}
