package com.sumaya.hw_week07_day04.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.hw_week07_day04.R
import com.sumaya.hw_week07_day04.data.modle.Results
import com.sumaya.hw_week07_day04.databinding.RecycleMovieItemBinding
import com.sumaya.hw_week07_day04.viewModels.DBviewModel

class DbAdapter(val Movies: List<Results>) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
       // val view = LayoutInflater.from(parent.context)
            //.inflate(R.layout.recycle_movie_item, parent, false)
        val bind: RecycleMovieItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.recycle_movie_item, parent, false)
        return CustomHolder(bind)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val movie = Movies[position]
        holder.bind(movie)
      //  holder.Title.text = movie.title
      //  holder.Date.text = movie.release_date
      //  holder.imageIV.load("https://image.tmdb.org/t/p/w500/" + movie.poster_path)
       // holder.VoteAverage.text = movie.vote_average.toString()
    }

    override fun getItemCount(): Int {
        return Movies.size
    }
}

class CustomHolder(val binding :RecycleMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.vm = DBviewModel()
    }

    // val Title: TextView = itemView.findViewById(R.id.title_movie)
    // val imageIV: ImageView = itemView.findViewById(R.id.poster)
    //val Date: TextView = itemView.findViewById(R.id.date)
    //val VoteAverage: TextView = itemView.findViewById(R.id.vote_average)
    fun bind(movie: Results) {
        binding.poster.load("https://image.tmdb.org/t/p/w500/" + movie.poster_path)
        binding.vm?.vmDB = movie
    }
}
