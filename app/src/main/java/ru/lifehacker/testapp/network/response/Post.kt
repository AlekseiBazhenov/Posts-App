package ru.lifehacker.testapp.network.response

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("id")
    val id: Long,
    @SerializedName("date")
    val date: String,
    @SerializedName("date_gmt")
    val dateGmt: String,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("modified_gmt")
    val modifiedGmt: String,
    @SerializedName("title")
    val title: Title,
    @SerializedName("content")
    val content: Content,
    @SerializedName("cat_cover")
    val catCover: CatCover,
    @SerializedName("author")
    val authorId: Long,
    @SerializedName("author_name")
    val authorName: String,
    @SerializedName("categories")
    val categories: List<Int>,
    @SerializedName("tags")
    val tags: List<Int>
) {
    data class Content(
        @SerializedName("rendered")
        val rendered: String
    )

    data class Title(
        @SerializedName("rendered")
        val rendered: String
    )

    data class CatCover(
        @SerializedName("sizes")
        val sizes: Sizes
    ) {
        data class Sizes (
            @SerializedName("mobile")
            val mobile: String?
        )
    }
}
