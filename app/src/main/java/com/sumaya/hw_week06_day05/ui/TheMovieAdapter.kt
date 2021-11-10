package com.sumaya.hw_week06_day05.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.hw_week06_day05.R
import com.sumaya.hw_week06_day05.URL_KEY
import com.sumaya.hw_week06_day05.data.models.Results
import com.sumaya.hw_week06_day05.databinding.MovieRecyclerviewItemBinding

class TheMovieAdapter(private val theMovieDataList: List<Results>) :
    RecyclerView.Adapter<TheMovieAdapter.CustomHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_recyclerview_item, parent, false)
        val bind : MovieRecyclerviewItemBinding=
            DataBindingUtil.inflate(LayoutInflater.from(parent.context)
                ,R.layout.movie_recyclerview_item,parent,false)
        return CustomHolder(bind)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val movieData = theMovieDataList[position]
        holder.bindFun(movieData)
    }

    override fun getItemCount(): Int {
        return theMovieDataList.size
    }

    class CustomHolder(private val binding: MovieRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        /*var txtTitle: TextView = binding.findViewById(R.id.tv_title)
        var txtDate: TextView = binding.findViewById(R.id.tv_date)
        var imageView: ImageView = binding.findViewById(R.id.iv_image)
        var txtVoteAverage: TextView = binding.findViewById(R.id.tv_vote_average)*/
        init {
            binding.vm = MainViewModel.MovieViewModel()
        }
         fun bindFun(movieData: Results) {
            binding.vm?.vmMovie = movieData
            binding.ivImage.load("https://image.tmdb.org/t/p/w500/" + binding.vm?.poster_path)
            binding.ivImage.setOnClickListener {
                val intent = Intent(binding.root.context,WebViewActivity::class.java)
                intent.putExtra(URL_KEY,"https://www.themoviedb.org/movie/"+binding.vm?.id)
                binding.root.context.startActivity(intent)
            }
        }
    }
}
