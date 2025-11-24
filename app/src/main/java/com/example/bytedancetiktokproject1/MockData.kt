package com.example.bytedancetiktokproject1

object MockData {
    fun mockData(count: Int): List<Experience> {
        val list = mutableListOf<Experience>()

        repeat(count) {
            list.add(
                Experience(
                    imageUrl = "https://picsum.photos/300/300?random=${Math.random()}",
                    title = "经验标题 $it",
                    avatarUrl = "https://i.pravatar.cc/100?img=$it",
                    username = "用户 $it",
                    liked = false,
                    likeCount = (20..500).random()
                )
            )
        }
        return list
    }
}