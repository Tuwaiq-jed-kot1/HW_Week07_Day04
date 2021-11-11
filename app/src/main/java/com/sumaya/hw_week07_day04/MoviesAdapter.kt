package com.sumaya.hw_week06_day05

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.hw_week07_day04.R
import com.sumaya.hw_week07_day04.ui.MoviesViewModel
import com.sumaya.hw_week07_day04.ui.MoviesWebView

class MoviesAdapter(private val moviesData: List<Results>) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {

        val binding: MoviesRecyclerViewItemBinding  = DataBindingUtil.inflate(LayoutInflater.from(parent.context).
        R.layout.movies_recyclerview_item, parent,false)
        return CustomHolder(binding)

    }
    override fun onBindViewHolder(holder: CustomHolder, position: Int) {

        val movie= moviesData[position]

        holder.bind(movie)

    }
    override fun getItemCount(): Int = moviesData.size


}

class CustomHolder(val binding: MoviesRecyclerViewItemBinding): RecyclerView.ViewHolder(binding.root) {

//    val title : TextView = itemView.findViewById(R.id.tvTitle)
//    val voteAverage :TextView = itemView.findViewById(R.id.tvVote)
//    val date: TextView = itemView.findViewById(R.id.tvDate)
//    val posterImage : ImageView = itemView.findViewById(R.id.ivImage)
//    lateinit var idTv: String
//    init{
//        posterImage.setOnClickListener(this)
//    }



        init {
            binding.movie = MoviesViewModel()
        }

//    override fun onClick(v: View?) {
//        val i = Intent(v!!.context, MoviesWebView::class.java)
//        i.putExtra("A",idTv)
//        v.context.startActivity(i)
//    }


        fun bind(movie: Results) {
            binding.movie?.vmMovie = movie
            binding.movieImageIV.load("https://image.tmdb.org/t/p/w500" + movie.poster_path)
        }


    }
