package com.example.retroapi.apidata

data class newsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)