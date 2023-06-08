package com.example.retroapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retroapi.Adapters.NewsListAdapter
import com.example.retroapi.apidata.Article
import com.example.retroapi.apidata.newsData
import retrofit2.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rcView: RecyclerView = findViewById(R.id.rcView)
        val news = newsObject.news.getHeadlines("us",1)

        news.enqueue(object : Callback<newsData>{
            override fun onResponse(call: Call<newsData>, response: Response<newsData>) {
//                Log.d("Test",response.body().toString())
//                val title = response.body()?.articles?.get(0)?.title
//                println(title)
                val articles: List<Article>? = response.body()?.articles
                //for list
                var  titles = mutableListOf<String>()
                var  imageLink = mutableListOf<String>()


                if (articles != null) {
                    for (article  in articles) {
                        titles.add(article.title)
                        imageLink.add(article.urlToImage)
//                        println(article.title)
                    }
                }

//                println("count="+imageLink.size)
                rcView.adapter = NewsListAdapter(titles,imageLink)
                rcView.layoutManager = LinearLayoutManager(applicationContext)


            }

            override fun onFailure(call: Call<newsData>, t: Throwable) {

                Log.d("Hello",t.localizedMessage.toString())

            }





        })











    }
}