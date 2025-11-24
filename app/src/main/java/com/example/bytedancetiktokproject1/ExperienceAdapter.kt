package com.example.bytedancetiktokproject1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ExperienceAdapter(
    private val list: MutableList<Experience>) : RecyclerView.Adapter<ExperienceAdapter.VH>() {

    inner class VH(v: View) : RecyclerView.ViewHolder(v) {
        val image = v.findViewById<ImageView>(R.id.image)
        val title = v.findViewById<TextView>(R.id.title)
        val avatar = v.findViewById<ImageView>(R.id.avatar)
        val username = v.findViewById<TextView>(R.id.username)
        val btnLike = v.findViewById<ImageView>(R.id.btnLike)
        val likeCount = v.findViewById<TextView>(R.id.likeCount)
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

        Glide.with(holder.image).load(item.imageUrl).into(holder.image)
        Glide.with(holder.avatar).load(item.avatarUrl).circleCrop().into(holder.avatar)
        holder.title.text = item.title
        holder.username.text = item.username
        holder.likeCount.text = item.likeCount.toString()

        // 点赞按钮
        holder.btnLike.setImageResource(
            if (item.liked) R.drawable.icon_like_on else R.drawable.icon_like_off
        )

        holder.btnLike.setOnClickListener {
            item.liked = !item.liked
            if (item.liked) item.likeCount++ else item.likeCount--
            notifyItemChanged(position)
        }

        // 图片预加载
        Glide.with(holder.image.context)
            .load(item.imageUrl)
            .preload()
    }

    override fun getItemCount() = list.size
}
