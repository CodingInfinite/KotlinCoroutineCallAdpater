package com.spartons.kotlincoroutinecalladapter.activites.mainActivity.ui

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.spartons.kotlincoroutinecalladapter.R
import com.spartons.kotlincoroutinecalladapter.activites.BaseActivity
import com.spartons.kotlincoroutinecalladapter.activites.mainActivity.di.DaggerMainActivityComponent
import com.spartons.kotlincoroutinecalladapter.activites.mainActivity.di.MainActivityModule
import com.spartons.kotlincoroutinecalladapter.activites.mainActivity.viewModel.MainActivityViewModel
import com.spartons.kotlincoroutinecalladapter.adapter.MovieAdapter
import com.spartons.kotlincoroutinecalladapter.response.MovieResponse
import com.spartons.kotlincoroutinecalladapter.util.nonNull
import com.spartons.kotlincoroutinecalladapter.util.observe
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    private lateinit var movieAdapter: MovieAdapter
    private val movies = mutableListOf<MovieResponse.Movie>()

    @Inject
    lateinit var picasso: Picasso
    @Inject
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainActivityComponent.builder()
            .mainActivityModule(MainActivityModule(this))
            .appComponent(getAppComponent())
            .build()
            .inject(this)
        moviesRecyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        moviesRecyclerView.setHasFixedSize(true)
        movieAdapter = MovieAdapter(this, movies, picasso)
        moviesRecyclerView.adapter = movieAdapter
        startListeningToNewMovies()
        listenToErrors()
    }

    private fun startListeningToNewMovies() {
        viewModel
            .movies
            .nonNull()
            .observe(this) {
                progressBar.visibility = View.GONE
                this.movies.addAll(it)
                movieAdapter.notifyDataSetChanged()
            }
    }


    private fun listenToErrors() {
        viewModel.error
            .nonNull()
            .observe(this) {
                progressBar.visibility = View.GONE
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
    }
}
