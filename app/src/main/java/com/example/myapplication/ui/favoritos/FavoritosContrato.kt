package com.example.myapplication.ui.favoritos

class FavoritosContrato {

    interface Presenter{

        fun pegarLista()
    }

    interface View{

        fun mostrarLista()
    }
}