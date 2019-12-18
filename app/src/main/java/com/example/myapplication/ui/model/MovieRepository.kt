package com.example.myapplication.ui.model

import android.content.Context
import android.util.Log
import com.example.myapplication.Service
import com.example.myapplication.ui.retrofit.RetrofitInitializer
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call
import android.widget.Toast

class MovieRepository {

    fun servicePopulares() {

        val call = RetrofitInitializer().service().populares
        call.enqueue(object : Callback<FilmeResponse>{
            override fun onFailure(call: Call<FilmeResponse>, t: Throwable) {
                Log.e("deu ruim", t?.message)
            }

            override fun onResponse(
                call: Call<FilmeResponse>,
                response: Response<FilmeResponse>
            ) {
                val objetoRecebido : FilmeResponse = response.body()!!
                val lista : List<Filme> = objetoRecebido.results
            }

        })












        /*val retrofitClient = RetrofitInitializer
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

            }
        })
*/
    }
}