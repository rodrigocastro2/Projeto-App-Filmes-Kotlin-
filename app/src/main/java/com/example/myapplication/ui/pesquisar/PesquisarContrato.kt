package com.example.myapplication.ui.pesquisar

import com.example.myapplication.ui.model.Filme

class PesquisarContrato {

    interface Presenter {

        fun pesquisa(tituloFilme: String)
    }

    interface View {

        fun updateRecycler(lista: List<Filme>)

    }
}