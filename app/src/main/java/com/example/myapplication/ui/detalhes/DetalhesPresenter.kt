package com.example.myapplication.ui.detalhes

import android.content.SharedPreferences
import com.example.myapplication.ui.favoritos.FavoritosUtils

class DetalhesPresenter(val view: DetalhesContrato.View) : DetalhesContrato.Presenter {

    override fun verificarFavorito(stringFavoritos: String?, id: Int): Boolean {
        if(stringFavoritos!!.isEmpty())
            return false
        val idString = id.toString()
        var listaFavoritos = FavoritosUtils.transformarStringLista(stringFavoritos)
        return listaFavoritos.contains(idString)
    }

    override fun adicionarFavoritos(
        stringFavoritos: String?,
        id: Int,
        editor: SharedPreferences.Editor
    ) {
        val idString = id.toString()
        val stringFavorito = "$stringFavoritos/$idString"
        editor.putString("favoritos", stringFavorito)
        editor.commit()
    }

    override fun removerFavoritos(
        stringFavoritos: String?,
        id: Int,
        editor: SharedPreferences.Editor
    ) {
        val idString = id.toString()
        var listaFavoritoMultable = FavoritosUtils.transformarStringLista(stringFavoritos).toMutableList()
        listaFavoritoMultable.remove(idString)
        val listaFavorito = listaFavoritoMultable.toList()
        val stringFavorito = FavoritosUtils.transformarListaString(listaFavorito)
        editor.putString("favoritos", stringFavorito)
        editor.commit()
    }

}