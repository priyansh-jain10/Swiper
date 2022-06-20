package com.example.swiper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {
    val items=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView=findViewById(R.id.listRecyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)
        val adapter=Adapter(items)
        recyclerView.adapter=adapter
        val swipe:SwipeRefreshLayout=findViewById(R.id.swipeRefreshLayout)
        swipe.setOnRefreshListener {
            updateData()
            adapter.notifyDataSetChanged()
            swipe.isRefreshing=false
        }
    }
    fun updateData():ArrayList<String>{
        val count=items.size+1
        items.add("item $count")
        return items
    }
}