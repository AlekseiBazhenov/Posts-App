package ru.lifehacker.testapp.data.api

import retrofit2.Call
import retrofit2.http.GET
import ru.lifehacker.testapp.data.enities.Post


interface PostsApi {

    @GET("/api/wp/v2/posts")
    fun getPosts(): Call<List<Post>>

}