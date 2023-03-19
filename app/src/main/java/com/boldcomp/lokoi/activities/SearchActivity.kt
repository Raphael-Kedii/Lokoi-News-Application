package com.boldcomp.lokoi.activities

import androidx.appcompat.app.AppCompatActivity
import com.boldcomp.lokoi.R
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.boldcomp.lokoi.adapters.NewsAdapter
import com.boldcomp.lokoi.api.NewsApiClient
import com.boldcomp.lokoi.api.NewsApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchActivity : AppCompatActivity() {
    private lateinit var searchView: SearchView
    private lateinit var recyclerView: RecyclerView
    private lateinit var noResultsTextView: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var newsAdapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
/**
        searchView = findViewById(R.id.search_view)
        recyclerView = findViewById(R.id.recycler_view)
        noResultsTextView = findViewById(R.id.no_results_text_view)
        progressBar = findViewById(R.id.progress_bar)

        recyclerView.layoutManager = LinearLayoutManager(this)
        newsAdapter = NewsAdapter(emptyList())
        recyclerView.adapter = newsAdapter
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    searchNews(it)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        }) */
    }
/**
    private fun searchNews(query: String) {
        val apiKey = "93fd4efc9e3945c8a35d297e990fcb1d"
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = NewsApiClient.service.searchNews(query, apiKey)
                val articles = response.articles
                withContext(Dispatchers.Main) {
                    newsAdapter.articles = articles
                    newsAdapter.notifyDataSetChanged()
                }
            } catch (e: Exception) {
                Log.e("SearchActivity", "Error searching news", e)
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@SearchActivity, "Error searching news", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    */
}