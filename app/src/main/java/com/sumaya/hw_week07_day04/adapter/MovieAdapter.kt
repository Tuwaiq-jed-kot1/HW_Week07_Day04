package com.sumaya.hw_week06_day05.adapter


import Results
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.hw_week06_day05.WebViewActivity
import com.sumaya.hw_week07_day04.R
import com.sumaya.hw_week07_day04.databinding.ItemRecyclerviewBinding
import com.sumaya.hw_week07_day04.viewmodel.VMMovie


class MovieAdapter(val moviesData: List<Results>) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {

        val binding: ItemRecyclerviewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_recyclerview, parent, false
        )


        return CustomHolder(binding)

    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val movies = moviesData[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int {
        return moviesData.size
    }

}

class CustomHolder(var binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {

    init {

        binding.movie = VMMovie()
    }

    fun bind(movie: Results) {
        binding.idImage.load("https://image.tmdb.org/t/p/w500" + movie.poster_path)

        binding.movie?.vmMovie = movie

    }

}