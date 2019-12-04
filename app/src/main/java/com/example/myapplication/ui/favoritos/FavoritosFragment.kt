package com.example.myapplication.ui.favoritos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R

class FavoritosFragment : Fragment(), FavoritosContrato.View {

    private lateinit var presenter: FavoritosPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = FavoritosPresenter(this)
        presenter.pegarLista()
        return inflater.inflate(R.layout.fragment_favoritos, container, false)

    }

    override fun mostrarLista() {

    }
}