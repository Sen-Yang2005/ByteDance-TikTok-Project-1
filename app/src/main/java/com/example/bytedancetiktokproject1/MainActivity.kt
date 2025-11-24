package com.example.bytedancetiktokproject1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


class MainActivity : AppCompatActivity (){
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefresh: SwipeRefreshLayout

    private val data = mutableListOf<Experience>()
    private lateinit var adapter: ExperienceAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvExperience)
        swipeRefresh = findViewById(R.id.refreshLayout)

        // 设置瀑布流 LayoutManager
        recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        adapter = ExperienceAdapter(data)
        recyclerView.adapter = adapter

        // 初始数据
        loadMockData()

        // 下拉刷新
        swipeRefresh.setOnRefreshListener {
            data.clear()
            loadMockData()
            adapter.notifyDataSetChanged()
            swipeRefresh.isRefreshing = false
        }

        // 上拉加载更多
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(rv: RecyclerView, newState: Int) {
                if (!rv.canScrollVertically(1)) {
                    loadMockData()
                    adapter.notifyDataSetChanged()
                }
            }
        })
    }

    private fun loadMockData() {
        repeat(20) {
            data.add(
                Experience(
                    "https://picsum.photos/300/300?random=${Math.random()}",
                    "经验标题 $it"
                )
            )
        }
    }
}
