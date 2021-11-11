package com.sumaya.hw_week07_day04.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.sumaya.hw_week07_day04.R

class MoviesWebView : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar



    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_webview)

        webView = findViewById(R.id.wvId)
        progressBar = findViewById(R.id.progressBar)
        progressBar.max = 100


        val moviesID:String? = intent.getStringExtra("A")

        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.themoviedb.org/movie/$moviesID")



        webView.webChromeClient = object : WebChromeClient(){
            override fun onReceivedTitle(view: WebView?, title: String?) {
                (this@MoviesWebView as AppCompatActivity).supportActionBar?.subtitle = title
            }

            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                if(newProgress == 100){
                    progressBar.visibility = View.GONE
                }else{
                    progressBar.visibility = View.VISIBLE
                    progressBar.progress = newProgress
                }
            }
        }

    }
}