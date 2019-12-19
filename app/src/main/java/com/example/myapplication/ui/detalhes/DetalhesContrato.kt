package com.example.myapplication.ui.detalhes

import android.content.SharedPreferences

class DetalhesContrato {

    interface Presenter{

        fun verificarFavorito(stringFavoritos: String?, id: Int):Boolean
        fun adicionarFavoritos(stringFavoritos: String?, id: Int, editor: SharedPreferences.Editor)
        fun removerFavoritos(stringFavoritos: String?, id: Int, editor: SharedPreferences.Editor)
    }

    interface View{

    }
}