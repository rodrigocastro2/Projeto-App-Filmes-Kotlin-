package com.example.myapplication.ui.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    fun init(){
        Retrofit.Builder()
            .baseUrl("www.omdbapi.com/?apikey=d672301e&")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}