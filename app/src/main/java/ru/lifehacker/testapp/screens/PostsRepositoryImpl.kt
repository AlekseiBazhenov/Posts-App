package ru.lifehacker.testapp.screens

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.lifehacker.testapp.database.PostEntity
import ru.lifehacker.testapp.database.PostsDao
import ru.lifehacker.testapp.network.LifeHackerApi
import ru.lifehacker.testapp.network.response.Post
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val api: LifeHackerApi,
    private val postsDao: PostsDao
) : PostsRepository {

    override fun load(): Flow<Resource<List<PostEntity>>> {
        return networkBoundResource(
            fetchFromLocal = { postsDao.getAll() },
//            shouldFetchFromRemote = { it == null },
            fetchFromRemote = {
                Log.d("", "")
                api.getPosts()
            },
            processRemoteResponse = { },
            saveRemoteData = { posts ->
                val entities = posts.map {
                    PostEntity(
                        id = it.id,
                        date = it.date,
                        dateGmt = it.dateGmt,
                        modified = it.modified,
                        modifiedGmt = it.modifiedGmt,
                        renderedTitle = it.title.rendered,
                        renderedContent = it.content.rendered,
                        catCoverSize = it.catCover.sizes.mobile,
                        authorId = it.authorId,
                        authorName = it.authorName,
                        categories = it.categories,
                        tags = it.tags
                    )
                }
                postsDao.insertAll(entities)
            },
            onFetchFailed = { _, _ -> }
        ).flowOn(Dispatchers.IO)
    }

//    override suspend fun load(): Flow<Result<List<Post>>> = flow {
//        try {
//            val response = api.getPosts()
////            if (response.raw().networkResponse().code() == 304){
////            }
//            val list = arrayListOf<PostEntity>()
//            response.forEach {
//                list.add(
//                    PostEntity(
//                        id = it.id,
//                        date = it.date,
//                        dateGmt = it.dateGmt,
//                        modified = it.modified,
//                        modifiedGmt = it.modifiedGmt,
//                        renderedTitle = it.title.rendered,
//                        renderedContent = it.content.rendered,
//                        catCoverSize = it.catCover.sizes.mobile,
//                        authorId = it.authorId,
//                        authorName = it.authorName,
//                        categories = it.categories,
//                        tags = it.tags
//                    )
//                )
//            }
//
//            postsDao.insertAll(list)
//
//            emit(Result.Success(response))
//        } catch (e: Exception) {
//            emit(Result.Failure(e))
//        }
//    }

}