package com.example.myapplication.ui.pesquisar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_pesquisar.*

class PesquisarFragment : Fragment(), PesquisarContrato.View {

    private lateinit var presenter: PesquisarPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = PesquisarPresenter(this)
        presenter.pesquisa()
        
        (activity as MainActivity).search = { onSearch(it) }
        
        return inflater.inflate(R.layout.fragment_pesquisar, container, false)
    }

    private fun onSearch(text: String) {
        text_pesquisar.text = text
    }


    override fun poePesquisaNaTela() {

    }

}
