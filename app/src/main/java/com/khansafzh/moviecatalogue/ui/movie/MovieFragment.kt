package com.khansafzh.moviecatalogue.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.khansafzh.moviecatalogue.R
import com.khansafzh.moviecatalogue.adapter.PopulerMovieAdapter
import com.khansafzh.moviecatalogue.adapter.UpcomingMovieAdapter
import com.khansafzh.moviecatalogue.model.movie.MovieItemResponse
import com.khansafzh.moviecatalogue.model.movie.MovieUpcomingResponse
import kotlinx.android.synthetic.main.fragment_movie.rv_popular_movie
import kotlinx.android.synthetic.main.fragment_movie.rv_upcoming_movie
import kotlinx.android.synthetic.main.fragment_movie.view.*

class MovieFragment : Fragment() {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var populerMovieAdapter: PopulerMovieAdapter
    private lateinit var upcomingMovieAdapter: UpcomingMovieAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_movie, container, false)

        movieViewModel =
                ViewModelProvider(this).get(MovieViewModel::class.java)

        //popular
        movieViewModel.init(1)
        movieViewModel.getData()
                .observe(viewLifecycleOwner, Observer { popularMovie ->
                    getInitPopular(popularMovie)
                })

        //upcoming
        movieViewModel.initUp(1)
        movieViewModel.getDataUpcoming().observe(viewLifecycleOwner, Observer { movieUpcoming ->
            getInitUpcoming(movieUpcoming )
        })
        return root
    }

    private fun getInitUpcoming(movieUpcoming: List<MovieUpcomingResponse>) {
        rv_upcoming_movie.apply {
            layoutManager = LinearLayoutManager(context,
                    LinearLayoutManager.VERTICAL, true)
            upcomingMovieAdapter = UpcomingMovieAdapter(movieUpcoming)
            rv_upcoming_movie.adapter = upcomingMovieAdapter
        }

    }


    private fun getInitPopular(popularMovie: List<MovieItemResponse>) {
        rv_popular_movie.apply {
            layoutManager = LinearLayoutManager(context,
                    LinearLayoutManager.HORIZONTAL, true
            )
            populerMovieAdapter = PopulerMovieAdapter(popularMovie)
            rv_popular_movie.adapter = populerMovieAdapter
        }
    }
}