package com.example.myapplication.ui.retrofit


import com.example.myapplication.Service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun service() : Service{
        return retrofit.create(Service::class.java)
    }

}