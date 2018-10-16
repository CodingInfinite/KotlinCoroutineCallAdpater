package com.spartons.kotlincoroutinecalladapter.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.spartons.kotlincoroutinecalladapter.R
import com.spartons.kotlincoroutinecalladapter.response.MovieResponse
import com.spartons.kotlincoroutinecalladapter.viewHolder.MovieViewHolder
import com.squareup.picasso.Picasso

class MovieAdapter constructor(
    private val context: Context,
    private val movies: List<MovieResponse.Movie>,
    private val picasso: Picasso = Picasso.with(context)
) :
    RecyclerView.Adapter<MovieViewHolder>() {

    companion object {
        const val IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w185"
    }

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder =
        MovieViewHolder(layoutInflater.inflate(R.layout.single_movie_item, p0, false))

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        val url = IMAGE_BASE_URL.plus(movie.poster_path)
        picasso.load(url).into(holder.moviePosterImageView)
        holder.movieRatingTextView.text = movie.vote_average.toString()
        holder.movieTitleTextView.text = movie.title

    }
}