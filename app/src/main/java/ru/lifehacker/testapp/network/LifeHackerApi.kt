package ru.lifehacker.testapp.network

import retrofit2.Response
import retrofit2.http.GET
import ru.lifehacker.testapp.network.response.Post

interface LifeHackerApi {

    @GET("wp/v2/posts")
    suspend fun getPosts(): Response<List<Post>>

}