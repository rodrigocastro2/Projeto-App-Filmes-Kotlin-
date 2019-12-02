package com.example.myapplication.ui.conteudo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R

class PopularesFragment : Fragment() {

    private lateinit var popularesViewModel: PopularesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        popularesViewModel =
            ViewModelProviders.of(this).get(PopularesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_populares, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        popularesViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}