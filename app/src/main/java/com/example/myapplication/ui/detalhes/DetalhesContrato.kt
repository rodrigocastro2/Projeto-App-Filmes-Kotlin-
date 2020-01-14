package com.example.myapplication.ui.detalhes

import android.content.SharedPreferences

//As duas interfaces da classe com as suas respectivas declaracoes funcoes (só o cabeçalho da funcao)
class DetalhesContrato {

    interface Presenter{

        fun verificarFavorito(stringFavoritos: String?, id: Int):Boolean
        fun adicionarFavoritos(stringFavoritos: String?, id: Int, editor: SharedPreferences.Editor)
        fun removerFavoritos(stringFavoritos: String?, id: Int, editor: SharedPreferences.Editor)
    }

    interface View{

    }
}