package com.example.myapplication.ui.conteudo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.ItemOffsetDecoration
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.ui.model.Filme
import com.example.myapplication.ui.model.FilmeResponse
import com.example.myapplication.ui.retrofit.RetrofitInitializer
import kotlinx.android.synthetic.main.fragment_populares.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PopularesFragment : Fragment(), PopularesContrato.View {

    private lateinit var presenter: PopularesPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_populares, container, false)
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


      /*  presenter = PopularesPresenter(this)
        presenter.pegarLista()
        */
    }

    override fun mostrarLista(/* lista */) {
        var textoDigitado = (activity as MainActivity)
        //Preencher recycle view
    }

    fun setupRecycler(lista: List<Filme>){

        recycler_populares.adapter = activity?.let { ListaPopularesAdapter(lista, it) }
        recycler_populares.layoutManager = GridLayoutManager(context, 2)

        val itemDecoration = ItemOffsetDecoration(context!!, R.dimen.item_offset)
        recycler_populares.addItemDecoration(itemDecoration)
    }


}