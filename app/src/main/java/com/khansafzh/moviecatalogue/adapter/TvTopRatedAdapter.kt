package com.khansafzh.moviecatalogue.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.khansafzh.moviecatalogue.BuildConfig
import com.khansafzh.moviecatalogue.R
import com.khansafzh.moviecatalogue.model.tv.TvResultItem
import kotlinx.android.synthetic.main.item_tv_top_rated.view.*

class TvTopRatedAdapter(var listTvTopRated: List<TvResultItem?>?) :
        RecyclerView.Adapter<TvTopRatedAdapter.TvTopRatedViewHolder>() {

    inner class TvTopRatedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(tvtoprated: TvResultItem?) {
            with(itemView) {
                Glide.with(context).load(BuildConfig.IMAGE_URL + tvtoprated?.posterPath)
                        .into(iv_top_rated)
                tv_title_top_rated.text = tvtoprated?.name
                tv_top_rated_desc.text = tvtoprated?.overview
                tv_date_top_rated.text = tvtoprated?.firstAirDate
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvTopRatedViewHolder {
        return TvTopRatedViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_tv_top_rated, parent, false)
        )
    }

    override fun getItemCount(): Int = listTvTopRated!!.size

    override fun onBindViewHolder(holder: TvTopRatedViewHolder, position: Int) {
        holder.bind(listTvTopRated?.get(position))
    }
}