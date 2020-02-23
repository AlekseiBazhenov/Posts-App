package ru.lifehacker.testapp.presentation

import ru.lifehacker.testapp.data.enities.Post

interface PostsContract {

    interface View {

        fun showError(error: String)

        fun showPosts(posts: List<Post>)
    }

    interface Presenter {

        fun onCreateView()
    }

}
