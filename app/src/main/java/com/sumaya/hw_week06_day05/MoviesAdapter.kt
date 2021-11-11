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
import com.sumaya.hw_week06_day05.databinding.MoviesRecyclerviewItemBinding
import com.sumaya.hw_week06_day05.vm.MoviesVM

class MoviesAdapter(private val moviesData: List<Results>) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {

        //val view = LayoutInflater.from(parent.context).inflate(R.layout.movies_recyclerview_item, parent,false)
        val bind = DataBindingUtil.inflate<MoviesRecyclerviewItemBinding>(LayoutInflater.from(parent.context),R.layout.movies_recyclerview_item,parent,false)
        return CustomHolder(bind)

    }


    override fun onBindViewHolder(holder: CustomHolder, position: Int) {

        val movie= moviesData[position]
        holder.bind(movie)

        /*holder.title.text="${movie.title}"
        holder.date.text=" ${movie.release_date}"
        holder.posterImage.load("https://image.tmdb.org/t/p/w500"+movie.poster_path)
        holder.voteAverage.text=" ${movie.vote_average}"
        holder.idTv= movie.id.toString()*/


    }

    override fun getItemCount(): Int {

        return moviesData.size
    }

}

class CustomHolder(val binding: MoviesRecyclerviewItemBinding):RecyclerView.ViewHolder(binding.root){

    /*val title : TextView = itemView.findViewById(R.id.tvTitle)
    val voteAverage :TextView = itemView.findViewById(R.id.tvVote)
    val date: TextView = itemView.findViewById(R.id.tvDate)
    val posterImage : ImageView = itemView.findViewById(R.id.ivImage)
    lateinit var idTv: String*/
    init {

        binding.movie= MoviesVM()
    }


    fun bind(movie: Results) {
        binding.ivImage.load("https://image.tmdb.org/t/p/w500${movie.poster_path}")
        binding.ivImage.setOnClickListener {
            val i = Intent(binding.ivImage.context,MoviesWebView::class.java)
                .apply {
                    putExtra("A", movie.id.toString())
                }
            itemView.context.startActivity(i)
        }
        binding.movie?.vmMovies = movie

    }


}