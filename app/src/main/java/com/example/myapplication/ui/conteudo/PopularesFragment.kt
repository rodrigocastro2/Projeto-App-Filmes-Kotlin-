package com.example.myapplication.ui.conteudo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R

class PopularesFragment : Fragment(), PopularesContrato.View {

    private lateinit var presenter: PopularesPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = PopularesPresenter(this)
        presenter.pegarLista()
        return inflater.inflate(R.layout.fragment_populares, container, false)
    }

    override fun mostrarLista(/* lista */) {
        //Preencher recycle view
    }

}