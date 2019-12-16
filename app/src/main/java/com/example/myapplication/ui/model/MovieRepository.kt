package com.example.myapplication.ui.model

import android.content.Context
import android.util.Log
import com.example.myapplication.MovieEndPoint
import com.example.myapplication.ui.retrofit.RetrofitInitializer
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call
import android.widget.Toast

class MovieRepository {

    fun getData() {
        val retrofitClient = RetrofitInitializer
            .getRetrofitInstance()

        val endpoint = retrofitClient.create(MovieEndPoint ::class.java)
        val callback = endpoint.populares()

        callback.enqueue(object : Callback<List<Filme>> {
            override fun onFailure(call: Call<List<Filme>>, t: Throwable) {
                Log.e("falha", "deu erro")

            }

            override fun onResponse(call: Call<List<Filme>>, response: Response<List<Filme>>) {
                response.body()?.forEach {
                    Log.e("sucesso", "deu carregou")
                }

            } //deu certo essa porra
        })

    }
}