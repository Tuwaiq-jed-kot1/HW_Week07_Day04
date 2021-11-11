package com.sumaya.hw_week07_day04

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.hw_week07_day04.databinding.MovieItemsBinding
import com.sumaya.hw_week07_day04.vm.MovieViewmodel

class MovieAdapter(val Movies :List<Results>) :RecyclerView.Adapter<MovieAdapter.CustomHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val bind = DataBindingUtil.inflate<MovieItemsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.movie_items, parent, false
        )
        return CustomHolder(bind)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
         val movie =Movies[position]
          holder.bind(movie)

       holder.image.setOnClickListener {
           val intent = Intent(holder.itemView.context,WebView::class.java)
           intent.putExtra("M",movie.id)
           holder.itemView.context.startActivity(intent)
       }

    }

    override fun getItemCount(): Int= Movies.size


    class CustomHolder(val binding: MovieItemsBinding):RecyclerView.ViewHolder(binding.root) {
        val image:ImageView= itemView.findViewById(R.id.ivMovie)

        init {
            binding.photo1 = MovieViewmodel()
        }

        fun bind(movie: Results) {
          binding.ivMovie.load("https://image.tmdb.org/t/p/w500"+movie.poster_path)
           binding.photo1?.vmMovie= movie
         /* binding.Title.text=movie.title
          binding.Vote.text= movie.vote_average.toString()*/
            //holder.info.load("https://www.themoviedb.org/movie/"+movie.id)

        }

    }

}