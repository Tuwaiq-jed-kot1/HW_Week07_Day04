package com.sumaya.hw_week07_day04.ui

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
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sumaya.hw_week07_day04.R
import com.sumaya.hw_week07_day04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val vm by lazy {
        ViewModelProvider(this).get(MainVM::class.java)
    }
    private val SHARED_KEY = "lastSearch"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        //setContentView(R.layout.activity_main)
        sharedPreferences = this.getSharedPreferences("movieSharePreference", MODE_PRIVATE)

        //movieRV = findViewById(R.id.rvMovie)
        binding.rvMovie.layoutManager = StaggeredGridLayoutManager(
            2,
            StaggeredGridLayoutManager.VERTICAL
        )//GridLayoutManager(this, 2)

        loadMovieImages()
    }

    private fun loadMovieImages(query: String? = null) {
        vm.fetchInterestingList(query).observe(this, {
            if (query.isNullOrEmpty()) {
                binding.rvMovie.adapter = MovieAdapter(it.results)

            } else {
                binding.rvMovie.swapAdapter(MovieAdapter(it.results), false)
            }
            Log.d("Movie Main Response", it.results.toString())
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchIcon: MenuItem = menu!!.findItem(R.id.app_bar_search)
        val TAG = "searchView"
        val searchView = searchIcon.actionView as SearchView
        searchView.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    Log.d(TAG, "Query text submit: $query")
                    val sharedPref =
                        sharedPreferences.getString(SHARED_KEY, "This was your 1st search!! ")
                    sharedPreferences
                        .edit()
                        .putString(SHARED_KEY, "Your last search was: $query")
                        .apply()
                    Toast.makeText(this@MainActivity, sharedPref, Toast.LENGTH_LONG).show()
                    loadMovieImages(query?.trim())
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    Log.d(TAG, "QueryTextChange: $newText")
                    return false
                }

            })
        }

        return super.onCreateOptionsMenu(menu)
    }
}