package com.example.myapplication.ui.detalhes

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myapplication.R
import com.example.myapplication.ui.model.Filme
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detalhes_filme.*

class DetalhesFilmes : AppCompatActivity(), DetalhesContrato.View {

    private lateinit var presenter: DetalhesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalhes_filme)
        val dados = intent.getSerializableExtra("dados") as Filme
        setupView(dados)

        presenter = DetalhesPresenter(this)

        var SharedPreferences = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val favoritos = SharedPreferences.getString("favoritos", "")
        val editor = SharedPreferences.edit()
        setupFavoritos(favoritos, dados.id, editor)

    }

    fun setupView(filme: Filme) {
        titulo_detalhes.text = filme.title
        sinopse.text = filme.overview
        nota.text = filme.vote_average

        val urlbase = "https://image.tmdb.org/t/p/w500"
        Picasso.get().load(urlbase + filme.poster_path).into(capa_detalhes)
    }

    fun setupFavoritos(favoritos: String?, id: Int, editor: SharedPreferences.Editor) {
        var isFavorite = presenter.verificarFavorito(favoritos, id)
        if (isFavorite){
            botaoaddfavoritos.background = ContextCompat.getDrawable(this, R.drawable.addfavoritos)
        }

        else{
            botaoaddfavoritos.background = ContextCompat.getDrawable(this, R.drawable.addfavoritoscinza)
        }
        botaoaddfavoritos.setOnClickListener {
            if (isFavorite){
                presenter.removerFavoritos(favoritos, id, editor)
                botaoaddfavoritos.background = ContextCompat.getDrawable(this, R.drawable.addfavoritoscinza)
                isFavorite = false
            }
            else{
                presenter.adicionarFavoritos(favoritos, id, editor)
                botaoaddfavoritos.background = ContextCompat.getDrawable(this, R.drawable.addfavoritos)
                isFavorite = true
            }
        }
    }
}