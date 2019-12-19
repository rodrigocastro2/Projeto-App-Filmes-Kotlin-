package com.example.myapplication.ui.favoritos

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.ui.detalhes.DetalhesFilmes
import com.example.myapplication.ui.model.Filme
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.viewholder.view.*

class FavoritosAdapter(private val listaFilmes: List<Filme>,
                       private val context: Context ):RecyclerView.Adapter<FavoritosAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.viewholder, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaFilmes.size
    }

    fun getItem(position: Int) = listaFilmes[position]

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filme = listaFilmes[position]
        holder.bind(filme)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetalhesFilmes::class.java)
            intent.putExtra("dados", filme)
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind(filme : Filme){

            val titulo = itemView.titulofilme
            titulo.text = filme.title

            val link_poster = "https://image.tmdb.org/t/p/w500"
            Picasso.get().load(link_poster+filme.poster_path).into(itemView.poster)
        }
    }
}