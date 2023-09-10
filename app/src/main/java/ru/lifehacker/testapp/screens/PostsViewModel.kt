package ru.lifehacker.testapp.screens

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.lifehacker.testapp.network.response.Post
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val repository: PostsRepository
) : ViewModel() {

    private val _uiState = mutableStateOf(UiState(isLoading = true, posts = emptyList()))
    val uiState: MutableState<UiState> = _uiState

    init {
        viewModelScope.launch {
            repository.load().collect { response ->
                Log.d("", "")
//                when (response) {
//                    is Result.Success<List<Post>> -> {
//                        _uiState.value =
//                            _uiState.value.copy(isLoading = false, posts = response.data!!)
//                    }
//                    is Result.Failure -> {
//                        Log.e("PostsViewModel", response.e.toString())
//                    }
//                }
            }
        }
    }
}

data class UiState(
    val isLoading: Boolean,
    val posts: List<Post>
)