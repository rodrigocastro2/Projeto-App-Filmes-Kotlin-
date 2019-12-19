package com.example.myapplication.ui.favoritos

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.ItemOffsetDecoration
import com.example.myapplication.R
import com.example.myapplication.ui.model.Filme
import kotlinx.android.synthetic.main.fragment_favoritos.*

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
        var sharedPreferences : SharedPreferences = this.activity!!.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val favoritos = sharedPreferences.getString("favoritos", "")
        presenter = FavoritosPresenter(this)
        setupRecycler(presenter.listaRetornadaMutable)
        favoritos?.let { presenter.retornarLista(it) }
    }

    private fun setupRecycler(lista: List<Filme>){
        recycler_favoritos.adapter = activity?.let { FavoritosAdapter(lista, it) }
        recycler_favoritos.layoutManager = GridLayoutManager(context, 2)

        val itemDecoration = ItemOffsetDecoration(context!!, R.dimen.item_offset)
        recycler_favoritos.addItemDecoration(itemDecoration)
    }

    override fun updateRecycler() {
        recycler_favoritos.adapter?.notifyDataSetChanged()
    }


}