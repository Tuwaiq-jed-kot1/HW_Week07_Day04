package com.sumaya.hw_week07_day04.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.hw_week07_day04.data.modules.Result
import com.sumaya.hw_week07_day04.data.network.MoviesWebView
import com.sumaya.hw_week07_day04.data.viewmodel.MoviesVM
import com.sumaya.hw_week07_day04.R
import com.sumaya.hw_week07_day04.databinding.RecyclerviewItemBinding


class MoviesAdapter( val moviesData: List<Result>) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {

        val bind: RecyclerviewItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.recyclerview_item, parent, false
        )
        return CustomHolder(bind)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val movie = moviesData[position]
        holder.bindFun(movie)
//        holder.titleTV.text = movies.title
//        holder.dateTV.text = movies.release_date
//        holder.votesTV.text = movies.vote_average.toString()
//        holder.imageIV.load("https://image.tmdb.org/t/p/original/"+ movies.poster_path)
//
//        holder.imageIV.setOnClickListener{
//            val intent= Intent( holder.itemView.context, MoviesWebView::class.java).apply {
//                putExtra("mKey",movies.id.toString())
//
//            }
//            holder.itemView.context.startActivity(intent)
//
//
//        }
    }

    override fun getItemCount(): Int {
        return moviesData.size
    }
}

class CustomHolder(val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.movie = MoviesVM()
    }


    fun bindFun(movie: Result) {
        binding.movie?.movieVM = movie
        binding.tvTitle.text = movie.title
        binding.tvDate.text = movie.release_date
        binding.tvVotes.text = movie.vote_average.toString()
        binding.ivPoster.load("https://image.tmdb.org/t/p/w500" + movie.poster_path)
        binding.ivPoster.setOnClickListener {
            val i = Intent(
                binding.ivPoster.context, MoviesWebView::class.java
            ).apply {
                putExtra("id", "${movie.id}")
            }
            itemView.context.startActivity(i)
        }
    }
}