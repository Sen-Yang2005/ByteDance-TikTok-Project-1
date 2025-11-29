# ByteDance TikTok Project 1 

## 项目简介
本项目是一个 Android 应用示例，模仿抖音的经验分享页面，实现了瀑布流展示、网络图片预加载、本地头像显示、点赞功能和下拉刷新加载。

## 功能特点
- 瀑布流布局，支持单列/双列切换
- 网络图片显示经验内容
- 本地头像显示用户头像
- 标题和用户名展示
- 点赞功能，点赞数实时更新
- 下拉刷新和滑动到底部自动加载更多数据
- 图片预加载和内存缓存优化，提升滑动流畅度

## 项目结构
  <img width="421" height="875" alt="Screenshot 2025-11-29 at 16 12 26" src="https://github.com/user-attachments/assets/1653cb19-2900-4660-8b85-6a29d6c01a13" />


## 使用方法
1. Fork 项目：
   你可以先 fork 该项目
   
2. Clone 项目：
   Fork 完成之后，复制 http 或 SSH,进入终端， 输入git clone + 你所复制的

3. 在 Android Studio 打开项目，确保 minSdkVersion >= 25

4. 在 build.gradle.kts(app)中添加依赖：
   
   implementation("androidx.recyclerview:recyclerview:1.4.0")
   
   implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
   
   implementation("androidx.constraintlayout:constraintlayout:2.2.1")
   
   implementation("androidx.cardview:cardview:1.0.0")
   
   implementation ("com.github.bumptech.glide:glide:4.16.0")
   
   添加完应如图所示： <img width="1753" height="1184" alt="Screenshot 2025-11-29 at 16 23 02" src="https://github.com/user-attachments/assets/aab0a5d2-43f8-49c8-948d-bcf2056e4a3b" />

5. 在 AndroidManifest.xml 中添加网络权限
   
   uses-permission android:name="android.permission.INTERNET" 
  
   添加完应如图所示： <img width="1105" height="996" alt="Screenshot 2025-11-29 at 16 17 46" src="https://github.com/user-attachments/assets/c567660f-68b3-4143-ae46-1cdfb9b37f5c" />

6. 将本地头像avatar_1-10 和 icon_like_on, icon_like_off放在 res/drawable/

   添加完应如图所示:
   
   <img width="417" height="560" alt="Screenshot 2025-11-29 at 20 55 42" src="https://github.com/user-attachments/assets/e118ff10-5d74-47dd-9cfa-ef520bceaab2" />

8. 点击运行项目

## 技术栈

  Kotlin
  RecyclerView StaggeredGridLayoutManager
  Glide 图片加载与缓存
  SwipeRefreshLayout 下拉刷新

