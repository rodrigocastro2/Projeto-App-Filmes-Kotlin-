package com.example.myapplication.ui.favoritos

class FavoritosUtils {

    companion object {
        /** Funcao para transformar uma String em uma lista de objetos,
         * funciona recebendo uma string e sempre que encontrar uma "/"
         * cria um novo elemento na lista*/
        @JvmStatic
        fun transformarStringLista(stringFavoritos: String?): List<String> {
            val stringSemBarra = stringFavoritos!!.removePrefix("/")
            var lista: List<String> = stringSemBarra.split("/")
            if(lista.first() == ""){
                return listOf()
            }
            return lista
        }

        /** Funcao para transformar uma lista em uma string com a "/" separando os elementos*/
        @JvmStatic
        fun transformarListaString(listaFavoritos : List<String> ) : String{

            val newString = listaFavoritos.joinToString("/")
            return newString
        }

    }

}