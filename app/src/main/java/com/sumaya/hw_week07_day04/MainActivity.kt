package com.sumaya.hw_week07_day04

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sumaya.hw_week07_day04.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

  //  private lateinit var Mov : RecyclerView
    private lateinit var sharedPreferences: SharedPreferences
    private  val vm by lazy {
        ViewModelProvider(this).get(MovieVM::class.java)
    }

    private lateinit var binding: ActivityMainBinding
    private val SHEARD_KEY = "lastSearch"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        //  Mov= findViewById(R.id.RvMovie)
        binding.RvMovie.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        sharedPreferences = this.getSharedPreferences("MovieSearchPreference", Context.MODE_PRIVATE)
        LoadImage()

    }
    private fun LoadImage(query:String? = null) {
        vm.fetchIntrestingList(query).observe(this, {
            if (query.isNullOrEmpty()) {
                binding.RvMovie.adapter = MovieAdapter(it.results)
            } else {
                binding.RvMovie.swapAdapter(MovieAdapter(it.results), false)
            }
            Log.d("Main", it.results.toString())
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu,menu)
        val tag = " searchView"
        val searchIcon: MenuItem = menu!!.findItem(R.id.app_bar_search)
        val searchView = searchIcon.actionView as SearchView
        searchView.apply {
            setOnQueryTextListener(object :SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    Log.d(tag,"Query Text Submit : $query")

                    val sharedPreference =sharedPreferences.getString(SHEARD_KEY,"this is your 1st search")
                    Toast.makeText(context,sharedPreference,Toast.LENGTH_SHORT).show()
                    sharedPreferences.edit().putString(SHEARD_KEY,"Your last search was : $query")
                        .apply()
                    LoadImage(query?.trim())
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    Log.d(tag,"Query Text Change: $newText" )
                    return false
                }
            })
        }
        return super.onCreateOptionsMenu(menu)
    }




}