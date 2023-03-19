package com.boldcomp.lokoi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.boldcomp.lokoi.R
import com.boldcomp.lokoi.adapters.NewsAdapter
import com.boldcomp.lokoi.api.NewsApiClient
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var newsApiClient: NewsApiClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    // Handle Home item click
                }
                R.id.search -> {
                    // Handle Search item click
                }
                R.id.profile -> {
                    // Handle Profile item click
                }
            }
            true
        }


        newsApiClient = NewsApiClient("93fd4efc9e3945c8a35d297e990fcb1d")

        lifecycleScope.launch {
            val articles = newsApiClient.getTopHeadlines()
            val recyclerView: RecyclerView = findViewById(R.id.newsRecyclerView)
            val adapter = NewsAdapter(articles)
            recyclerView.adapter = adapter
        }

    }
}