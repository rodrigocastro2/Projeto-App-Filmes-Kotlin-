package com.example.myapplication.ui.favoritos

import com.example.myapplication.ui.model.Filme

class FavoritosContrato {

    interface Presenter{

        fun retornarLista(favoritosString : String)
    }

    interface View{

        fun updateRecycler()
    }
}