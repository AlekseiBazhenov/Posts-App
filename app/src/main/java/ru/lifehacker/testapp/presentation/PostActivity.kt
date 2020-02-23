package ru.lifehacker.testapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_post.*
import ru.lifehacker.testapp.R


class PostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val content = intent.extras?.getString(EXTRA_POST)

        webView.loadData(content, "text/html; charset=utf-8", "UTF-8")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_POST = "EXTRA_POST"
    }
}
