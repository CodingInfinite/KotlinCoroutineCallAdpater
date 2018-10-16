package com.spartons.kotlincoroutinecalladapter.viewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.spartons.kotlincoroutinecalladapter.R

class MovieViewHolder (itemView1: View) : RecyclerView.ViewHolder(itemView1) {

    val moviePosterImageView: ImageView = itemView1.findViewById(R.id.moviePosterImageView)
    val movieRatingTextView: TextView = itemView1.findViewById(R.id.movieRatingTextView)
    val movieTitleTextView: TextView = itemView1.findViewById(R.id.movieTitleTextView)
}