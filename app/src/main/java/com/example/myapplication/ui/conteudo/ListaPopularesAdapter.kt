package com.example.myapplication.ui.conteudo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.ui.model.Filme
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.viewholder.view.*

class ListaPopularesAdapter(private val listaFilmes: List<Filme>,
                            private val context: Context) : RecyclerView.Adapter<ListaPopularesAdapter.ViewHolder>() {

    //Inflar o XML do ViewHolder(Antes da lista ser criada)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(context).inflate(R.layout.viewholder, parent, false)
        return ViewHolder(view)
    }


    //Após a lista ser criada, chamará o "bind" dentro da classe "ViewHolder"
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    //O get item vai passar a posição do exato objeto que foi clicado, para ser resgatada no bind
    fun getItem(position: Int) = listaFilmes[position]



    //Passa o tamanho da lista
    override fun getItemCount(): Int {
        return listaFilmes.size
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //O método bind irá setar a capa e qualquer outro visual
        fun bind(filme : Filme){
            Picasso.get().load(filme.urlFoto).resize(160, 230).placeholder(R.drawable.fancicani).into(itemView.imagemcapa)
            itemView.titulofilme.text = filme.nome
        }
    }
}