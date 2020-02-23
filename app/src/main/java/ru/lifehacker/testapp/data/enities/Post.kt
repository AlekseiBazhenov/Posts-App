package ru.lifehacker.testapp.data.enities

import com.google.gson.annotations.SerializedName

class Post {

    @SerializedName("title")
    lateinit var title: Title

    @SerializedName("content")
    lateinit var content: Content

    @SerializedName("cat_cover")
    lateinit var catCover: CatCover


    inner class Title {
        @SerializedName("rendered")
        lateinit var rendered: String
    }

    inner class Content {
        @SerializedName("rendered")
        lateinit var rendered: String
    }

    inner class CatCover {
        @SerializedName("sizes")
        lateinit var sizes: Sizes
    }

    inner class Sizes {
        @SerializedName("mobile")
        lateinit var mobile: String

        fun exist() = ::mobile.isInitialized
    }
}
