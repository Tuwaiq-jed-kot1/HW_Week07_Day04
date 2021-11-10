package com.sumaya.hw_week07_day04.ui

import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sumaya.hw_week07_day04.R
import com.sumaya.hw_week07_day04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val shared_key = "last search"
    private val vm by lazy {
        ViewModelProvider(this).get(VMmovies ::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false);

        sharedPreferences=this.getSharedPreferences("moviesSearchSharedPreference", Context.MODE_PRIVATE)
        binding.RV.layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        loadMoviesToAdapter()
    }

    private fun loadMoviesToAdapter(query: String? =null) {
        vm.getAllMovies(query).observe(this, {
            if(query.isNullOrEmpty()){
                it
                binding.RV.adapter = MovieAdapter(it.results)
            }else {
                binding.RV.scrollToPosition(0)
                binding.RV.swapAdapter(MovieAdapter(it.results), false)
            }
            Log.d("TMDB main response ", it.results.toString())
        })
    }








    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.movie_menu,menu)
        val searchIcon: MenuItem =menu!!.findItem(R.id.app_bar_search)

        val searchView =searchIcon.actionView as SearchView
        searchView.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener{

                override fun onQueryTextSubmit(query: String?): Boolean {
                    Log.d(ContentValues.TAG,"QueryTextSubmit :$query")
                    val sharedpref=sharedPreferences.getString(shared_key,"this was your 1st search")
                    Toast.makeText(context,sharedpref, Toast.LENGTH_SHORT).show()
                    sharedPreferences.edit()
                        .putString(shared_key,"your last search was $query").apply()
                    loadMoviesToAdapter(query?.trim())
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    Log.d(ContentValues.TAG,"QueryTextChange :$newText")

                    return false
                }
            })

            // this.setIconified(true)
            //this.setFocusable(true)
        }
        return super.onCreateOptionsMenu(menu)
    }


}