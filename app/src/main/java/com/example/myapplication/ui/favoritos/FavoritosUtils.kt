package com.example.myapplication.ui.favoritos

class FavoritosUtils {

    companion object {
        @JvmStatic
        fun transformarStringLista(stringFavoritos: String?): List<String> {
            val stringSemBarra = stringFavoritos!!.removePrefix("/")
            var lista: List<String> = stringSemBarra.split("/")
            if(lista.first() == ""){
                return listOf()
            }
            return lista
        }

        @JvmStatic
        fun transformarListaString(listaFavoritos : List<String> ) : String{

            val newString = listaFavoritos.joinToString("/")
            return newString
        }

    }

}