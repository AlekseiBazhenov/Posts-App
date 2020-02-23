package ru.lifehacker.testapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.lifehacker.testapp.R
import ru.lifehacker.testapp.data.enities.Post

class PostsAdapter(
    private val items: List<Post>,
    private val itemClick: (String) -> Unit
) : RecyclerView.Adapter<PostViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_post,
            parent,
            false
        ), itemClick
    )

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindPost(items[position])
    }
}