package com.boldcomp.lokoi.models

data class NewsArticle(
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?,

)
