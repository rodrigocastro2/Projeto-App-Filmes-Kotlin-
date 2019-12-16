package com.example.myapplication.ui.conteudo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.ItemOffsetDecoration
import com.example.myapplication.MainActivity
import com.example.myapplication.MovieEndPoint
import com.example.myapplication.R
import com.example.myapplication.ui.model.Filme
import com.example.myapplication.ui.retrofit.RetrofitInitializer
import kotlinx.android.synthetic.main.fragment_populares.*
import retrofit2.Call
import retrofit2.Callback


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

        setupRecycler()

        presenter = PopularesPresenter(this)
        presenter.pegarLista()
    }

    override fun mostrarLista(/* lista */) {
        var textoDigitado = (activity as MainActivity)
        //Preencher recycle view
    }

    fun setupRecycler(){

        val filme1 = Filme()
        val filme2 = Filme()
        val filme3 = Filme()

        filme1.urlFoto = "https://m.media-amazon.com/images/M/MV5BMTczNTI2ODUwOF5BMl5BanBnXkFtZTcwMTU0NTIzMw@@._V1_SX300.jpg"
        filme2.urlFoto = "https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg"
        filme3.urlFoto = "https://m.media-amazon.com/images/M/MV5BMjIyZGU4YzUtNDkzYi00ZDRhLTljYzctYTMxMDQ4M2E0Y2YxXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_SX300.jpg"

        filme1.nome = "FILME 1"
        filme2.nome = "FILME 2"
        filme3.nome = "FILME 3"

        val lista = mutableListOf(filme1, filme2, filme3)


        recycler_populares.adapter = activity?.let { ListaPopularesAdapter(lista, it) }

        recycler_populares.layoutManager = GridLayoutManager(context, 2)

        val itemDecoration = ItemOffsetDecoration(context!!, R.dimen.item_offset)

        recycler_populares.addItemDecoration(itemDecoration)

    }


}