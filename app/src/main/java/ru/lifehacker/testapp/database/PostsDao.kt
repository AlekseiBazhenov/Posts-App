package ru.lifehacker.testapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostsDao {

    @Query("SELECT * FROM posts")
    suspend fun getAll(): List<PostEntity> // todo flow

    @Query("SELECT * FROM posts WHERE id = :id LIMIT 1")
    suspend fun loadById(id: IntArray): PostEntity

    @Insert
    suspend fun insertAll(posts: List<PostEntity>)

    @Delete
    suspend fun delete(post: PostEntity)

    // delete by ids
}