package com.example.myapplication.ui.conteudo

import android.util.Log
import com.example.myapplication.ui.model.Filme
import com.example.myapplication.ui.model.FilmeResponse
import com.example.myapplication.ui.model.MovieRepository
import com.example.myapplication.ui.retrofit.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularesPresenter(val view:PopularesContrato.View) : PopularesContrato.Presenter {

    override fun pegarLista() {

            val call = RetrofitInitializer().service().populares
            call.enqueue(object : Callback<FilmeResponse> {
                override fun onFailure(call: Call<FilmeResponse>, t: Throwable) {
                    Log.e("deu ruim", t?.message)
                }

                override fun onResponse(
                    call: Call<FilmeResponse>,
                    response: Response<FilmeResponse>
                ) {
                    val objetoRecebido: FilmeResponse = response.body()!!
                    val lista: List<Filme> = objetoRecebido.results
                }
            })
    }
}

