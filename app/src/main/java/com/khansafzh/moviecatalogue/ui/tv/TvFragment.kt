package com.khansafzh.moviecatalogue.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.khansafzh.moviecatalogue.R
import com.khansafzh.moviecatalogue.adapter.TvPopularAdapter
import com.khansafzh.moviecatalogue.adapter.TvTopRatedAdapter
import com.khansafzh.moviecatalogue.model.tv.TvResultItem
import kotlinx.android.synthetic.main.fragment_tv.*

class TvFragment : Fragment() {
    private lateinit var TvTopRatedAdapter: TvTopRatedAdapter
    private lateinit var popularTvPopularAdapter: TvPopularAdapter
    private lateinit var tvViewModel: TvViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_tv, container, false)
        tvViewModel =
            ViewModelProvider(this).get(TvViewModel::class.java)

        tvViewModel.init(1)
        tvViewModel.initUp(1)
        tvViewModel.getTvPopularData().observe(viewLifecycleOwner, Observer { tvPopular -> getInitTvPopular(tvPopular) })
        tvViewModel.getDataTopRated().observe(viewLifecycleOwner, Observer { tvTopRated -> getInitTopRated(tvTopRated) })
        return root
    }

    private fun getInitTopRated(tvTopRated: List<TvResultItem?>?){
        rv_top_rated.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
            TvTopRatedAdapter = TvTopRatedAdapter(tvTopRated)
            rv_top_rated.adapter = TvTopRatedAdapter
        }
    }

    private fun getInitTvPopular(tvPopular: List<TvResultItem?>?) {
        rv_popular_tv.apply {
            layoutManager =  LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            popularTvPopularAdapter = TvPopularAdapter(tvPopular)
            rv_popular_tv.adapter = popularTvPopularAdapter
        }
    }

}