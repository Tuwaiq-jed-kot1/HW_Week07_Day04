package com.sumaya.hw_week06_day05.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.data.viewModel.MoviesViewModel
import com.sumaya.hw_week06_day05.R
import com.sumaya.hw_week06_day05.data.models.Movie
import com.sumaya.hw_week06_day05.databinding.MovieItemBinding

class MoviesAdapter(val MoviesData: List<Movie>) : RecyclerView.Adapter<CustomHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val bind: MovieItemBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.movie_item, parent, false
            )
        return CustomHolder(bind)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val movie = MoviesData[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return MoviesData.size
    }
}

class CustomHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.vm = MoviesViewModel()

    }

    fun bind(movie: Movie) {

        binding.ivPoster.load("https://image.tmdb.org/t/p/w500/${movie.poster_path}")

        binding.vm?.vmMovies = movie
        binding.ivPoster.setOnClickListener {
            binding.linearLay1.visibility = View.GONE
            binding.webV.visibility = View.VISIBLE
            binding.webV.webViewClient = WebViewClient()
            binding.webV.loadUrl("https://www.themoviedb.org/movie/${movie.id}")
            binding.cancelButton.visibility = View.VISIBLE

        }
        binding.cancelButton.setOnClickListener {
            binding.linearLay1.visibility = View.VISIBLE
            binding.webV.visibility = View.GONE
            binding.cancelButton.visibility = View.GONE
        }

    }


}
