package com.example.retroapi

import com.example.retroapi.apidata.newsData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//GET https://newsapi.org/v2/top-headlines?country=us&apiKey=4ab7bb10071c461fbcdd83a5cedc0fbd
//GET https://newsapi.org/v2/everything?q=bitcoin&apiKey=4ab7bb10071c461fbcdd83a5cedc0fbd

const val api: String = "4ab7bb10071c461fbcdd83a5cedc0fbd"
const val baseUrl = "https://newsapi.org/"


interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$api")
    fun getHeadlines(@Query("country") country: String, @Query("page") page: Int): Call<newsData>

}
//https://newsapi.org/v2/top-headlines?apiKey=4ab7bb10071c461fbcdd83a5cedc0fbd?country=us?page=1


object newsObject {
    val news: NewsInterface

    init {
        val retrofit =
            Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .build()
        news = retrofit.create(NewsInterface::class.java)
    }


}
