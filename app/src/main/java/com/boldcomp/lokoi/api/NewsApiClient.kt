package com.boldcomp.lokoi.api

import com.boldcomp.lokoi.models.NewsArticle
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.boldcomp.lokoi.api.NewsApiService

class NewsApiClient (private val apiKey: String) {

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originalRequest = chain.request()
            val newUrl = originalRequest.url.newBuilder()
                .addQueryParameter("apiKey", apiKey)
                .build()
            val newRequest = originalRequest.newBuilder()
                .url(newUrl)
                .build()
            chain.proceed(newRequest)
        }
        .build()

     val service: NewsApiService by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(NewsApiService::class.java)
    }

    suspend fun getTopHeadlines(): List<NewsArticle> = runBlocking {
        val response = service.getTopHeadlines("us")
        response.articles.map {
            NewsArticle(it.author, it.title, it.description, it.url, it.urlToImage, it.publishedAt, it.content)
        }
    }
}