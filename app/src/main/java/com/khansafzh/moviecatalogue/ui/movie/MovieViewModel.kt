package com.khansafzh.moviecatalogue.ui.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.khansafzh.moviecatalogue.BuildConfig
import com.khansafzh.moviecatalogue.model.movie.MovieItemResponse
import com.khansafzh.moviecatalogue.model.movie.MoviePopularResponse
import com.khansafzh.moviecatalogue.model.movie.MovieUpcomingItemResponse
import com.khansafzh.moviecatalogue.model.movie.MovieUpcomingResponse
import com.khansafzh.moviecatalogue.model.tv.TvResultItem
import com.khansafzh.moviecatalogue.network.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    fun init(page: Int) {
        getPopularMovie(page)
    }

    //Data
    private val data = MutableLiveData<List<MovieItemResponse>>()

    private fun getPopularMovie(page: Int) {
        RetrofitConfig().getApiService().getPopularMovie(BuildConfig.API_KEY, page)
            .enqueue(object : Callback<MoviePopularResponse> {
                override fun onResponse(
                    call: Call<MoviePopularResponse>,
                    response: Response<MoviePopularResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseMovie: MoviePopularResponse? = response.body()
                        data.postValue(responseMovie?.result)
                    }
                }

                override fun onFailure(call: Call<MoviePopularResponse>, t: Throwable) {
                    Log.e("failure", t.toString())
                }
            })
    }

    //get all attribut dari populer movie
    fun getData(): LiveData<List<MovieItemResponse>> {
        return data
    }



    /*================================= Upcoming Movie ====================*/
    // call page
    fun initUp(page: Int) {
        getUpcoming(page)
    }

    private val dataUpcoming = MutableLiveData<List<MovieUpcomingResponse>>()
    private fun getUpcoming(page: Int) {
        RetrofitConfig().getApiService().getUpcomingMovie(BuildConfig.API_KEY, page)
            .enqueue(object : Callback<MovieUpcomingItemResponse> {
                override fun onResponse(
                    call: Call<MovieUpcomingItemResponse>,
                    response: Response<MovieUpcomingItemResponse>
                ) {
                    if (response.isSuccessful) {
                        val upcomingResponse: MovieUpcomingItemResponse? = response.body()
                        dataUpcoming.postValue(upcomingResponse?.result)
                    }
                }

                override fun onFailure(call: Call<MovieUpcomingItemResponse>, t: Throwable) {
                    Log.e("failure", t.toString())
                }
            })
    }
    fun getDataUpcoming(): LiveData<List<MovieUpcomingResponse>>{
        return dataUpcoming
    }
}