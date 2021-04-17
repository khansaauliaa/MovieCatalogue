package com.khansafzh.moviecatalogue.model.movie

import com.google.gson.annotations.SerializedName
import com.khansafzh.moviecatalogue.model.tv.TvResultItem

data class MovieUpcomingResponse(

	@SerializedName("poster_path")
	val poster_path:String,
	@SerializedName("title")
	val title:String,
	@SerializedName("release_date")
	val release_date:String,
	@SerializedName("overview")
	val overview:String

)



