package com.example.myapplication.ui.conteudo

import com.example.myapplication.ui.model.Filme

class PopularesContrato {

    //As duas interfaces da classe com as suas respectivas declaracoes funcoes (só o cabeçalho da funcao)

    interface Presenter{

        fun pegarLista()

    }

    interface View{

        fun setupRecycler(lista :List<Filme>)

    }

}