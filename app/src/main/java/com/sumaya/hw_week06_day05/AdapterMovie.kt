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
import com.sumaya.hw_week06_day05.databinding.RvItemBinding

class AdapterMovie(val movieData:List<Results>): RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val bind: RvItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.rv_item, parent, false)
        return CustomHolder(bind)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
val movie=movieData[position]
        holder.bind(movie)

    }

    override fun getItemCount(): Int {
      return movieData.size
    }
}

class CustomHolder (val binding :RvItemBinding):RecyclerView.ViewHolder(binding.root){
    init {
        binding.vm = PhotosViewModel()
    }
    fun bind(movie: Results) {
        binding.vm?.vmPhoto= movie
        binding.imagePoster.load("https://image.tmdb.org/t/p/w500"+movie.poster_path)
        binding.txtTitle.text=movie.title
        binding.txDate.text=movie.release_date
        binding.txtVote.text=movie.vote_average.toString()
        binding.imagePoster.setOnClickListener{
            val intent = Intent(binding.imagePoster.context,WebView::class.java)
            val URL_KEY="URL"
            intent.putExtra(URL_KEY,"https://www.themoviedb.org/movie/"+movie.id)
            binding.imagePoster.context.startActivity(intent)
        }

    }

}
