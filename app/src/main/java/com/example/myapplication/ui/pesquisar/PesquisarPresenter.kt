package com.example.myapplication.ui.pesquisar

class PesquisarPresenter constructor(val View: PesquisarContrato.View) : PesquisarContrato.Presenter {



    override fun pesquisa() {
        View.poePesquisaNaTela()
    }
}