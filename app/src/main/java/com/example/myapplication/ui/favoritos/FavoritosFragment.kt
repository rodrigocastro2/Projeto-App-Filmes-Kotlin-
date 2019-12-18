package com.example.myapplication.ui.favoritos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.ItemOffsetDecoration
import com.example.myapplication.R
import com.example.myapplication.ui.model.Filme
import com.example.myapplication.ui.model.FilmeResponse
import com.example.myapplication.ui.retrofit.RetrofitInitializer
import kotlinx.android.synthetic.main.fragment_favoritos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoritosFragment : Fragment(), FavoritosContrato.View {

    private lateinit var presenter: FavoritosPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favoritos, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

                setupRecycler(lista)
            }
        })
    }

    override fun mostrarLista() {

    }

    fun setupRecycler(lista: List<Filme>){

        recycler_favoritos.adapter = activity?.let { FavoritosAdapter(lista, it) }
        recycler_favoritos.layoutManager = GridLayoutManager(context, 2)

        val itemDecoration = ItemOffsetDecoration(context!!, R.dimen.item_offset)
        recycler_favoritos.addItemDecoration(itemDecoration)
    }


}