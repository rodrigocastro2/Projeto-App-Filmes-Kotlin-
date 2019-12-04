package com.example.myapplication.ui.pesquisar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R

class PesquisarFragment : Fragment(), PesquisarContrato.View {

    private lateinit var presenter: PesquisarPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = PesquisarPresenter(this)
        presenter.pesquisa()
        return inflater.inflate(R.layout.fragment_pesquisar, container, false)

    }

    override fun poePesquisaNaTela() {

    }

}
