package ru.lifehacker.testapp.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PostDetails(content: String) {
    Text(text = "PostDetails $content")
//    content?.let { webView.loadData(it, "text/html; charset=utf-8", "UTF-8") }
}

@Preview
@Composable
fun PreviewPostDetails() {
    PostDetails("Android")
}