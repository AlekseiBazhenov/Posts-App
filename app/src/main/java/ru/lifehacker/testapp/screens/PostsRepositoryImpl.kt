package ru.lifehacker.testapp.screens

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.lifehacker.testapp.network.LifeHackerApi
import ru.lifehacker.testapp.network.response.Post
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val api: LifeHackerApi
) : PostsRepository {

    override suspend fun load(): Flow<Result<List<Post>>> = flow {
        try {
            val response = api.getPosts()
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }
}