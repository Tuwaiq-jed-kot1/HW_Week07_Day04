package com.sumaya.hw_week06_day05.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.shady.restandretrofit.data.viewModels.MoviesViewModels
import com.sumaya.hw_week06_day05.R
import com.sumaya.hw_week06_day05.Results
import com.sumaya.hw_week06_day05.databinding.TmdbRecyclerViewBinding

class TMDBAdapter(val movieData: List<Results>) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): CustomHolder {
        val binding : TmdbRecyclerViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.tmdb_recycler_view,
            parent,
            false
        )
        return CustomHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val movie = movieData[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movieData.size
    }

}

class CustomHolder(val binding: TmdbRecyclerViewBinding) :

    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.movie = MoviesViewModels()
    }

    //    val titleTV: TextView = itemView.findViewById(R.id.tvFlickr)
    //    val imageIV: ImageView = itemView.findViewById(R.id.ivFlickr)
    fun bind(movie: Results) {
        binding.movie?.vmMovie = movie
        binding.movieImageIV.load("https://image.tmdb.org/t/p/w500" + movie.poster_path)
    }
}