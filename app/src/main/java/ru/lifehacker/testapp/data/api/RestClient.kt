package ru.lifehacker.testapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RestClient {

    private val baseUrl = "https://lifehacker.ru/"

    fun create(): PostsApi {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
        return retrofit.create<PostsApi>(PostsApi::class.java)
    }
}