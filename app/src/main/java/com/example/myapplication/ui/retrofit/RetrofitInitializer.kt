package com.example.myapplication.ui.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInitializer {

    companion object {

        fun getRetrofitInstance() : Retrofit {
            val interceptor = HttpLoggingInterceptor()
            interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
    }
}