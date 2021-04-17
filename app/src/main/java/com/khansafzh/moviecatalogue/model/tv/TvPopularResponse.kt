package com.khansafzh.moviecatalogue.model.tv

import com.google.gson.annotations.SerializedName
import com.khansafzh.moviecatalogue.model.tv.TvResultItem

data class TvPopularResponse(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("results")
	val results: List<TvResultItem?>? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
)


