package ru.lifehacker.testapp.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_post.view.*
import ru.lifehacker.testapp.data.enities.Post

class PostViewHolder (
    view: View,
    private val itemClick: (String) -> Unit
) : RecyclerView.ViewHolder(view) {

    fun bindPost(post: Post) {
        with(itemView) {

            setOnClickListener { itemClick(post.content.rendered) }

            name.text = post.title.rendered

            val image = post.catCover.sizes
            if (image.exist()) {
                Glide
                    .with(context)
                    .load(image.mobile)
                    .into(cover)
            }
        }
    }

}