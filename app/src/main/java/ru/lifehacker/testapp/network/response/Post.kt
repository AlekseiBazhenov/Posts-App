package ru.lifehacker.testapp.network.response

import com.google.gson.annotations.SerializedName

// todo add full data from response
data class Post(
    @SerializedName("id")
    val id: Long,
    @SerializedName("date")
    val date: String,
    @SerializedName("title")
    val title: Title,
    @SerializedName("content")
    val content: Content,
    @SerializedName("cat_cover")
    val catCover: CatCover
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
