package com.example.myapplication.ui.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Filme() : Serializable {

     lateinit var poster_path: String
     lateinit var title: String
     var id: Int = 0
     lateinit var overview: String
     var video: Boolean = false
     lateinit var vote_count: String
     lateinit var vote_average: String
     lateinit var media_type: String
     lateinit var popularity: String
     var adult: Boolean = false
     lateinit var backdrop_path: String
     lateinit var genre_ids: Array<Int>
     lateinit var original_title: String
     lateinit var original_language: String
     lateinit var release_date: String

}