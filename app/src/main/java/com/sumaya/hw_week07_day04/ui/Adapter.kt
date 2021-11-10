package com.sumaya.hw_week07_day04.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.hw_week07_day04.R
import com.sumaya.hw_week07_day04.data.model.MovieViewModel
import com.sumaya.hw_week07_day04.data.model.Results
import com.sumaya.hw_week07_day04.databinding.GridItemBinding

class Adapter(private val movies: List<Results>, private val mainVM: MainVM) :
    RecyclerView.Adapter<CustomHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val binding: GridItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.grid_item,parent,false)
        return CustomHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val movie = movies[position]


        holder.bind(movie,mainVM)


    }

    override fun getItemCount(): Int {
        return movies.size
    }

}

class CustomHolder(private val binding: GridItemBinding) : RecyclerView.ViewHolder(binding.root) {

   init {
       binding.movie= MovieViewModel()
   }

    fun bind(movie: Results, mainVM: MainVM) {
        binding.movie?.movie =movie
        binding.poster.load("https://image.tmdb.org/t/p/w500" + movie.poster_path)

        binding.rate.setOnClickListener {
            mainVM.rateMovie(10.0, movie.id).observeForever {
                Toast.makeText(
                    binding.root.context,
                    "${it.status_code} ${it.status_message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        binding.delete.setOnClickListener {
            mainVM.deleteRateMovie(movie.id).observeForever {
                Toast.makeText(
                    binding.root.context,
                    "${it.status_code} ${it.status_message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        binding.poster.setOnClickListener {
            val intent = Intent(binding.root.context, WebView::class.java)
            intent.putExtra(MOVIE_ID, movie.id)
            binding.root.context.startActivity(intent)
        }




    }



}
