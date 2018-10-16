package com.spartons.kotlincoroutinecalladapter.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieResponse {

    @SerializedName(value = "page")
    @Expose
    var page: Int = 0
    @SerializedName(value = "results")
    @Expose
    var movies: List<Movie> = ArrayList()

    class Movie constructor(
        val title: String,
        val vote_average: Double,
        val poster_path: String,
        val release_date: String
    )
}