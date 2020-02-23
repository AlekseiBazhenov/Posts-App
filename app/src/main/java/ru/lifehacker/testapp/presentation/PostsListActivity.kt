package ru.lifehacker.testapp.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_posts_list.*
import ru.lifehacker.testapp.R
import ru.lifehacker.testapp.data.api.RestClient
import ru.lifehacker.testapp.data.enities.Post

class PostsListActivity : AppCompatActivity(), PostsContract.View {

    lateinit var presenter: PostsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts_list)

        val api = RestClient().create()
        presenter = PostsPresenter(this, api)

        presenter.onCreateView()
    }

    override fun showError(error: String) {
        Toast.makeText(this@PostsListActivity, error, Toast.LENGTH_LONG).show()
    }

    override fun showPosts(posts: List<Post>) {
        list.layoutManager = LinearLayoutManager(this@PostsListActivity)
        list.adapter = PostsAdapter(posts) {
            val intent = Intent(
                this@PostsListActivity,
                PostActivity::class.java
            )

            intent.putExtra(
                PostActivity.EXTRA_POST,
                it
            )

            startActivity(intent)
        }
    }
}
