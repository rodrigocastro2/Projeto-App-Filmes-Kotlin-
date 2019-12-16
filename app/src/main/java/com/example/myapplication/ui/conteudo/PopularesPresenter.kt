package com.example.myapplication.ui.conteudo

import com.example.myapplication.ui.model.MovieRepository

class PopularesPresenter(val view:PopularesContrato.View) : PopularesContrato.Presenter {

    private var servico = MovieRepository()

    override fun pegarLista() {

        servico.getData()

    }


}