package com.example.myapplication.ui.favoritos

import android.util.Log
import com.example.myapplication.Service
import com.example.myapplication.ui.model.Filme
import com.example.myapplication.ui.retrofit.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoritosPresenter(val view: FavoritosContrato.View) : FavoritosContrato.Presenter {

    var listaRetornadaMutable = mutableListOf<Filme>()

    override fun retornarLista(favoritosString: String) {

        var favoritosLista = FavoritosUtils.transformarStringLista(favoritosString)

        for (id in favoritosLista) {

            val call = RetrofitInitializer().service().getFilmeId(id, Service.api_key)
            call.enqueue(object : Callback<Filme> {
                override fun onFailure(call: Call<Filme>, t: Throwable) {
                    Log.e("deu ruim", t?.message)
                }

                override fun onResponse(call: Call<Filme>, response: Response<Filme>) {
                    response.body()?.let { listaRetornadaMutable.add(it) }
                    view.updateRecycler()
                }
            })
        }
    }
}