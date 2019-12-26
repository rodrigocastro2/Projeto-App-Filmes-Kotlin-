package com.example.myapplication.ui.favoritos

class FavoritosContrato {

    interface Presenter{

        fun retornarLista(favoritosString : String)
    }

    interface View{

        fun updateRecycler()
    }
}