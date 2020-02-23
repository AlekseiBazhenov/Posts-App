package ru.lifehacker.testapp.presentation

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.lifehacker.testapp.data.api.PostsApi
import ru.lifehacker.testapp.data.enities.Post

class PostsPresenter(
    private val view: PostsContract.View,
    private val api: PostsApi
) : PostsContract.Presenter {

    override fun onCreateView() {
        api.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>?, error: Throwable?) {
                view.showError(error.toString())
            }

            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                response?.body()?.let { view.showPosts(it) }
            }
        })
    }
}