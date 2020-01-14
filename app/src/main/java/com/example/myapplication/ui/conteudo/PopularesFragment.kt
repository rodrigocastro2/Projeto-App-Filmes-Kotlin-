package com.example.myapplication.ui.conteudo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.ItemOffsetDecoration
import com.example.myapplication.R
import com.example.myapplication.ui.model.Filme
import kotlinx.android.synthetic.main.fragment_populares.*


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

        /** Chama a funcao pegarLista implementada no Presenter */
        presenter = PopularesPresenter(this)
        presenter.pegarLista()

    }

    /** Seta o recycler com o adapter e seu tipo de layout*/
    override fun setupRecycler(lista: List<Filme>){

        recycler_populares.adapter = activity?.let { PopularesAdapter(lista, it) }
        recycler_populares.layoutManager = GridLayoutManager(context, 2)

        val itemDecoration = ItemOffsetDecoration(context!!, R.dimen.item_offset)
        recycler_populares.addItemDecoration(itemDecoration)
    }
}