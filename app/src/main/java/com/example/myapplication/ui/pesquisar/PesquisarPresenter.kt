package com.example.myapplication.ui.pesquisar

import android.util.Log
import com.example.myapplication.Service
import com.example.myapplication.ui.model.Filme
import com.example.myapplication.ui.model.FilmeResponse
import com.example.myapplication.ui.retrofit.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PesquisarPresenter constructor(val View: PesquisarContrato.View) :
    PesquisarContrato.Presenter {

    var lista = listOf<Filme>()

    override fun pesquisa(tituloFilme: String) {
        val call = RetrofitInitializer().service().getPesquisa(Service.api_key, tituloFilme, "1")
        call.enqueue(object : Callback<FilmeResponse> {
            override fun onFailure(call: Call<FilmeResponse>, t: Throwable) {
                Log.e("deu ruim pesquisa", t?.message)
            }

            override fun onResponse(call: Call<FilmeResponse>, response: Response<FilmeResponse>) {
                if (response.body() != null) {
                    val objetoRecebido: FilmeResponse = response.body()!!
                    lista = objetoRecebido.results
                    View.updateRecycler(lista)
                }
            }
        })
    }
}