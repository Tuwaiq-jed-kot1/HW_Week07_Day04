package com.sumaya.hw_week06_day05.data.network

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.hw_week06_day05.R
import com.sumaya.hw_week06_day05.WebViewActivity
import com.sumaya.hw_week06_day05.data.modules.Results
import com.sumaya.hw_week06_day05.data.viewmodels.MoviesVM
import com.sumaya.hw_week06_day05.databinding.RecyclerviewItemBinding
import com.sumaya.hw_week06_day05.ui.MainVM

class MoviesAdapter(val moviesData: List<Results>) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {

        val bind: RecyclerviewItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.recyclerview_item, parent, false
        )
        return CustomHolder(bind)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val movie = moviesData[position]
        holder.bindFun(movie)
//        holder.titleTV.text=movie.title.toString()
//        holder.dateTV.text=movie.release_date.toString()
//        holder.votesTV.text=movie.vote_average.toString()
//        holder.imageIV.load("https://image.tmdb.org/t/p/original/"+movie.poster_path){
//        }
//
//        holder.itemView.setOnClickListener{
//            val intent= Intent( holder.itemView.context, WebViewActivity::class.java).apply {
//                putExtra("webKey",movie.id.toString())
//            }
//            holder.itemView.context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int = moviesData.size
}

class CustomHolder(val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.movie = MoviesVM()
    }

    fun bindFun(movie: Results) {
        binding.movie?.movieVM = movie
        binding.tvTitle.text = movie.title
        binding.tvDate.text = movie.release_date
        binding.tvVotes.text = movie.vote_average.toString()
        binding.ivPoster.load("https://image.tmdb.org/t/p/w500" + movie.poster_path)
        binding.ivPoster.setOnClickListener {
            val i = Intent(
                binding.ivPoster.context, WebViewActivity::class.java
            ).apply {
                putExtra("id", "${movie.id}")
            }
            itemView.context.startActivity(i)
        }
    }
}




