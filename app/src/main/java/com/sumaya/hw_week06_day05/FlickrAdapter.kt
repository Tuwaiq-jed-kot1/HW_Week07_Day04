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
import com.sumaya.hw_week06_day05.databinding.RecycleViewItemBinding
import com.tuwaiq.restandretrofit.data.network.models.Results


class FlickrAdapter(val moviesData:List<Results>) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_item,parent,false)
        val binding: RecycleViewItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycle_view_item,parent,false
        )
        return CustomHolder(binding)

    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val movies = moviesData[position]
/*        holder.textTitle.text = movies.title
        holder.textDate.text = movies.release_date
        holder.textVotes.text = movies.vote_average.toString()
        holder.poster.load("https://image.tmdb.org/t/p/w500"+movies.poster_path)*/
        //holder.idTV = movies.id.toString()
        holder.bind(movies)
    }

    override fun getItemCount(): Int {
        return moviesData.size
    }

}


    class CustomHolder(var binding: RecycleViewItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {

            binding.recycleVM = VM()
        }

        fun bind(movie: Results) {
            binding.ivPoster.load("https://image.tmdb.org/t/p/w500" + movie.poster_path)

            binding.recycleVM?.vmPhoto = movie

            binding.ivPoster.setOnClickListener {
                val i = Intent(
                    binding.imageView.context, WebViewActivity::class.java
                ).apply {
                    putExtra("id", "${movie.id.toString()}")
                }
                itemView.context.startActivity(i)
            }


        }

}