package com.khansafzh.moviecatalogue.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.khansafzh.moviecatalogue.BuildConfig
import com.khansafzh.moviecatalogue.R
import com.khansafzh.moviecatalogue.model.tv.TvResultItem
import kotlinx.android.synthetic.main.item_popular_tv.view.*

class TvPopularAdapter(var listTvPopular: List<TvResultItem?>?) : RecyclerView.Adapter<TvPopularAdapter.TvPopularViewHolder>() {
    inner class TvPopularViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(tvPopular: TvResultItem?) {
            with(itemView) {
                Glide.with(context)
                        .load(BuildConfig.IMAGE_URL + tvPopular?.posterPath)
                        .into(iv_tv_poster_popular)
                tv_title_popular_tv.text = tvPopular?.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvPopularAdapter.TvPopularViewHolder {
        return TvPopularViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_popular_tv, parent, false))
    }

    override fun getItemCount(): Int = listTvPopular!!.size

    override fun onBindViewHolder(holder: TvPopularAdapter.TvPopularViewHolder, position: Int) {
        holder.bind(listTvPopular?.get(position))
    }


}