package ru.lifehacker.testapp.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun Posts(
    viewModel: PostsViewModel = hiltViewModel(),
    onPostClick: (String) -> Unit
) {

    val isLoading = viewModel.uiState.value.isLoading

    AnimatedVisibility(visible = isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    }

    AnimatedVisibility(visible = !isLoading) {
        LazyColumn {
            items(viewModel.uiState.value.posts) {
                Text(
                    modifier = Modifier.clickable { onPostClick(it.content.rendered) },
                    text = it.title.rendered
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewPosts() {
    Posts() {}
}