package com.example.bytedancetiktokproject1

object MockData {

    val avatarList = listOf(
        R.drawable.avatar_1,
        R.drawable.avatar_2,
        R.drawable.avatar_3,
        R.drawable.avatar_4,
        R.drawable.avatar_5,
        R.drawable.avatar_6,
        R.drawable.avatar_7,
        R.drawable.avatar_8,
        R.drawable.avatar_9,
        R.drawable.avatar_10,
    )

    fun mockData(count: Int): List<Experience> {
        val list = mutableListOf<Experience>()

        repeat(count) {
            val randomAvatarId = avatarList.random()

            list.add(
                Experience(
                    imageUrl = "https://picsum.photos/300/300?random=${Math.random()}",
                    title = "经验标题 $it",
                    avatarID = randomAvatarId,
                    username = "用户 $it",
                    liked = false,
                    likeCount = (20..1000).random()
                )
            )
        }
        return list
    }
}
