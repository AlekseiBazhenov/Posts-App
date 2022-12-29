package ru.lifehacker.testapp.screens

import kotlinx.coroutines.flow.Flow
import ru.lifehacker.testapp.network.response.Post

interface PostsRepository {
    suspend fun load(): Flow<Result<List<Post>>>
}