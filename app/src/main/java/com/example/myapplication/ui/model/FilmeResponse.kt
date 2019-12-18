package com.example.myapplication.ui.model

class FilmeResponse {

    lateinit var page: String
    lateinit var results: List<Filme>
    var total_results: Int = 0
    var total_pages: Int = 0

}