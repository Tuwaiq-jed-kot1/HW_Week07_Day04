package com.sumaya.hw_week07_day04.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.hw_week07_day04.data.models.Results
import com.sumaya.hw_week07_day04.R
import com.sumaya.hw_week07_day04.data.models.vm.MovieVM
import com.sumaya.hw_week07_day04.databinding.RecycleviewItemBinding

class Movie_RV_Adapter(val videosData: List<Results>, private val activity: MainActivity) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val bind : RecycleviewItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.recycleview_item,parent,false)
        return CustomHolder(bind)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val movie = videosData[position]
        holder.bind(movie)
//        holder.movieTitle.text = movie.title
//        holder.movieDate.text = movie.release_date
//        holder.movieRate.text = movie.vote_average.toString()
//        holder.moviePoster.load("https://image.tmdb.org/t/p/w500"+movie.poster_path)
//        holder.moviePoster.setOnClickListener{
//            activity.navigateToWebViewFragment(movie.id)
//        }
    }

    override fun getItemCount(): Int {
        return videosData.size
    }
}


class CustomHolder(val binding:RecycleviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
//    val movieTitle:TextView = itemView.findViewById(R.id.MovieTitle)
//    val movieDate:TextView = itemView.findViewById(R.id.MovieDate)
//    val movieRate:TextView = itemView.findViewById(R.id.MovieRate)
//    val moviePoster:ImageView = itemView.findViewById(R.id.MoviePoster)
init {
    binding.movie= MovieVM()
}
    fun bind(movie: Results){
        binding.MoviePoster.load("https://image.tmdb.org/t/p/w500"+movie.poster_path)
        binding.movie?.vmMovie=movie
    }
}
