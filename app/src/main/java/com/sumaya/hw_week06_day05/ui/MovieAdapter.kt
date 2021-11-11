package com.sumaya.hw_week07_day04.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.hw_week07_day04.R
import com.sumaya.hw_week07_day04.databinding.MovieRvBinding
import com.sumaya.hw_week07_day04.network.models.Results
import com.sumaya.hw_week07_day04.viewModels.MoviesViewModel

class MovieAdapter(val movieData: List<Results>) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val bind= DataBindingUtil.inflate<MovieRvBinding>(LayoutInflater.from(parent.context),R.layout.movie_rv,parent,false)
        return CustomHolder(bind)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val movie= movieData[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movieData.size
    }

}

class CustomHolder(val binding: MovieRvBinding) : RecyclerView.ViewHolder(binding.root){
    init {
        binding.movie = MoviesViewModel()
    }
    fun bind(movie: Results) {
        binding.movie?.vmMovie = movie
        binding.ivPoster.load("https://image.tmdb.org/t/p/w500"+movie.poster_path)


        binding.ivPoster.setOnClickListener{
            val i = Intent(binding.ivPoster.context,
                MovieWebView::class.java).apply {
                putExtra("show", movie.id.toString())
            }
            itemView.context.startActivity(i)
        }
    }
}
