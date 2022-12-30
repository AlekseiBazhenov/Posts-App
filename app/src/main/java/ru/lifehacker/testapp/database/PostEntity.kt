package ru.lifehacker.testapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "date_gmt")
    val dateGmt: String,

    @ColumnInfo(name = "modified")
    val modified: String,

    @ColumnInfo(name = "modified_gmt")
    val modifiedGmt: String,

    @ColumnInfo(name = "title")
    val renderedTitle: String,

    @ColumnInfo(name = "content")
    val renderedContent: String,

    @ColumnInfo(name = "cat_cover")
    val catCoverSize: String?,

    @ColumnInfo(name = "author_id")
    val authorId: Long,

    @ColumnInfo(name = "author_name")
    val authorName: String,

    @ColumnInfo(name = "categories")
    val categories: List<Int>,

    @ColumnInfo(name = "tags")
    val tags: List<Int>
)
