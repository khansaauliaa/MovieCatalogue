package com.khansafzh.moviecatalogue.model.movie

import com.google.gson.annotations.SerializedName
import com.khansafzh.moviecatalogue.model.tv.TvResultItem

data class MoviePopularResponse(

	@SerializedName("page")
	val page:Int,
	@SerializedName("results")
	val result: ArrayList<MovieItemResponse>

)

