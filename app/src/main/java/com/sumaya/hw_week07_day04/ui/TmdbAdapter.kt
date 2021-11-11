package com.sumaya.hw_week06_day05.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.hw_week06_day05.data.models.TmdbMovie
import com.sumaya.hw_week06_day05.data.viewmodels.MovieViewModel
import com.sumaya.hw_week07_day04.R
import com.sumaya.hw_week07_day04.databinding.TmdbRecycleviewItemBinding

class TmdbAdapter(val moviesData: List<TmdbMovie>) : RecyclerView.Adapter<TmdbAdapter.CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.tmdb_recycleview_item, parent, false)
        val bind: TmdbRecycleviewItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.tmdb_recycleview_item, parent, false)
        return CustomHolder(bind)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val movie = moviesData[position]
        holder.bind(movie)
//        holder.titleTV.text = movie.title
//        holder.voteTV.text = movie.vote_average.toString()
//        holder.dateTV.text = movie.release_date
//        holder.moviePoster.load("https://image.tmdb.org/t/p/w500" + movie.poster_path)
//        holder.idTV = movie.id.toString()


    }

    override fun getItemCount(): Int {
        return moviesData.size
    }

    class CustomHolder(val binding : TmdbRecycleviewItemBinding) : RecyclerView.ViewHolder(binding.root),

        View.OnClickListener {

        init {
          binding.vm = MovieViewModel()
        }

//        val titleTV: TextView = itemView.findViewById(R.id.tvTitle)
//        val voteTV: TextView = itemView.findViewById(R.id.tvVote)
//        val dateTV: TextView = itemView.findViewById(R.id.tvDate)
        val moviePoster: ImageView = itemView.findViewById(R.id.ivPoster)
        lateinit var idTV: String
        init {
            moviePoster.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val intent = Intent(v!!.context,WebViewActivity::class.java)
            intent.putExtra("A",idTV)
            v.context.startActivity(intent)
        }

        fun bind(movie: TmdbMovie){
            binding.ivPoster.load("https://image.tmdb.org/t/p/w500" + movie.poster_path)
            binding.vm?.vmMovie = movie
        }

    }
}
