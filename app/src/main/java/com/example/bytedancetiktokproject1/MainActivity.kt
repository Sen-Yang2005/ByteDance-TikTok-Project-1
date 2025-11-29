package com.example.bytedancetiktokproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var swipe: SwipeRefreshLayout
    private lateinit var switchBtn: Button
    private var isTwoColumn = true
    private val data = mutableListOf<Experience>()
    private lateinit var adapter: ExperienceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.recyclerView)
        swipe = findViewById(R.id.swipeRefresh)
        switchBtn = findViewById(R.id.btnSwitch)

        //默认双列布局
        updateLayoutManager()

        adapter = ExperienceAdapter(data)
        recycler.adapter = adapter
        recycler.setHasFixedSize(true) // 固定大致高度
        recycler.setItemViewCacheSize(10) // 提前缓存10个经验卡

        loadMoreData()

        swipe.setOnRefreshListener {
            data.clear()
            loadMoreData()
            swipe.isRefreshing = false
        }

        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(rv: RecyclerView, newState: Int) {
                if (!rv.canScrollVertically(1)) {
                    loadMoreData()
                }
            }
        })

        //单列/双列切换
        switchBtn.setOnClickListener {
            isTwoColumn = !isTwoColumn
            updateLayoutManager()
        }
    }

    fun loadMoreData() {
        data.addAll(MockData.mockData(20))
        adapter.notifyDataSetChanged()
    }

    fun updateLayoutManager() {
        recycler.layoutManager = StaggeredGridLayoutManager(
            if (isTwoColumn) 2 else 1,
            StaggeredGridLayoutManager.VERTICAL
        )
    }
}
