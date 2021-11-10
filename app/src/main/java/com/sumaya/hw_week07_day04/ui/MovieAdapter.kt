package com.sumaya.hw_week06_day05.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.shady.restandretrofit.data.viewModels.PhotosViewModel
import com.sumaya.hw_week06_day05.Results
import com.sumaya.hw_week07_day04.R
import com.sumaya.hw_week07_day04.databinding.MovieItemBinding

class MovieAdapter (val moviesData: List<Results>) : RecyclerView.Adapter<CustomHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
//        return CustomHolder(view)
        val bind :MovieItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.movie_item, parent , false)
        return CustomHolder(bind)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val movies = moviesData[position]
        holder.bind(movies)
//        holder.titleTV.text = movies.title
//        holder.dateTV.text = movies.release_date
//        holder.votesTV.text = movies.vote_average.toString()
//        holder.imageIV.load("https://image.tmdb.org/t/p/original/" + movies.poster_path)
//        holder.imageIV.setOnClickListener {
//            val intent = Intent(holder.imageIV.context, MoviesWebView::class.java).apply {
//                putExtra("click", movies.id.toString())
//            }
//            holder.itemView.context.startActivity(intent)
//        }
    }
    override fun getItemCount(): Int {
        return moviesData.size
    }

}

    class CustomHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
//        val titleTV: TextView = itemView.findViewById(R.id.tvTitle)
//        val dateTV: TextView = itemView.findViewById(R.id.tvDate)
//        val votesTV: TextView = itemView.findViewById(R.id.tvVotes)
//        val imageIV: ImageView = itemView.findViewById(R.id.ivPoster)
init {
    binding.movie= PhotosViewModel()
}
        fun bind (Movie : Results) {
            binding.ivPoster.load("https://image.tmdb.org/t/p/w500" + Movie.poster_path)

            binding.movie?.vmMovie = Movie

            binding.ivPoster.setOnClickListener {
                val i = Intent(
                    binding.ivPoster.context, MoviesWebView::class.java
                ).apply {
                    putExtra("id", "${Movie.id.toString()}")
                }
                itemView.context.startActivity(i)
            }

        }

    }

