package com.example.myapplication.ui.pesquisar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.ItemOffsetDecoration
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.ui.model.Filme
import kotlinx.android.synthetic.main.fragment_pesquisar.*

class PesquisarFragment : Fragment(), PesquisarContrato.View {

    private lateinit var presenter: PesquisarPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pesquisar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = PesquisarPresenter(this)
        setupRecycler(presenter.lista)
        (activity as MainActivity).search = { onSearch(it) }
    }

    private fun onSearch(text: String) {
        text.let { presenter.pesquisa(text) }
    }

    private fun setupRecycler(lista: List<Filme>) {
        recycler_pesquisar.adapter = activity?.let { PesquisarAdapter(lista, it) }
        recycler_pesquisar.layoutManager = GridLayoutManager(context, 2)

        val itemDecoration = ItemOffsetDecoration(context!!, R.dimen.item_offset)
        recycler_pesquisar.addItemDecoration(itemDecoration)
    }

    override fun updateRecycler(lista: List<Filme>) {
        recycler_pesquisar.adapter = activity?.let { PesquisarAdapter(lista, it) }
        recycler_pesquisar.layoutManager = GridLayoutManager(context, 2)
    }

}
