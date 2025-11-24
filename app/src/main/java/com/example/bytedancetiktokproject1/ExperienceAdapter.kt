package com.example.bytedancetiktokproject1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ExperienceAdapter(
    private val list: MutableList<Experience>
) : RecyclerView.Adapter<ExperienceAdapter.VH>() {

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
        val title: TextView = itemView.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_experience, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = list[position]

        // 动态高度模拟瀑布流效果
        val randomHeight = (500..900).random()
        holder.image.layoutParams.height = randomHeight

        Glide.with(holder.image.context)
            .load(item.imageUrl)
            .into(holder.image)

        holder.title.text = item.title
    }

    override fun getItemCount() = list.size
}
