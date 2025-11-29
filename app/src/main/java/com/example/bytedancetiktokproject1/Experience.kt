package com.example.bytedancetiktokproject1

import android.os.Debug
import java.net.URL

class Experience(
    val imageUrl: String,
    val title: String,
    val avatarID: Int,
    val username: String,
    var liked: Boolean = false,
    var likeCount: Int = 0
)