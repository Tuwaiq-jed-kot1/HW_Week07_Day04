package com.sumaya.hw_week07_day04.ui
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.sumaya.hw_week07_day04.R
import com.sumaya.hw_week07_day04.databinding.MovieItemBinding
import com.sumaya.hw_week07_day04.data.movie
import com.sumaya.hw_week07_day04.data.viewmodels.MovieViewModel

class MovieAdapter(private val movies: List<movie>) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false)
        val bind: MovieItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.movie_item, parent, false)
        return CustomHolder(bind)

    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val movie =movies[position]
        holder.bind(movie)

        holder.itemView.setOnClickListener{
            val intent= Intent( holder.itemView.context, WebViewActivity::class.java).apply {
              putExtra("webKey",movie.id.toString())
            }
            holder.itemView.context.startActivity(intent)


        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}

class CustomHolder(val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
    val title: TextView = itemView.findViewById(R.id.title)
    val date: TextView = itemView.findViewById(R.id.date)
    val vote_average: TextView = itemView.findViewById(R.id.vote_average)
    val Image: ImageView = itemView.findViewById(R.id.imageView)
    init {
        binding.movie= MovieViewModel()
    }

    fun bind(movie: movie) {
        binding.imageView.load("https://image.tmdb.org/t/p/original/"+movie.poster_path){
            scale(Scale.FILL)
        }
        binding.movie?.movie = movie

    }

}