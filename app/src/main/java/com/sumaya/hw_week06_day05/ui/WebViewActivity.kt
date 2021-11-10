package com.sumaya.hw_week06_day05.ui

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sumaya.hw_week06_day05.R
import com.sumaya.hw_week06_day05.URL_KEY
import com.sumaya.hw_week06_day05.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding
    /*private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_web_view)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_web_view)
        val webView = binding.wvMovie
        val progressBar = binding.progressBar
        progressBar.max = 100
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        intent.getStringExtra(URL_KEY)?.let { webView.loadUrl(it) }
        webView.webChromeClient = object : WebChromeClient() {
            override fun onReceivedTitle(view: WebView?, title: String?) {
                (this@WebViewActivity as AppCompatActivity).supportActionBar?.subtitle = title
            }

            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                if (newProgress == 100) {
                    progressBar.visibility = View.GONE
                } else {
                    progressBar.visibility = View.VISIBLE
                    progressBar.progress = newProgress
                }
            }
        }

    }
}