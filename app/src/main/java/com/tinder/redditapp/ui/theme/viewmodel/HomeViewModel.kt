package com.tinder.redditapp.ui.theme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tinder.redditapp.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.tinder.redditapp.data.Result
import com.tinder.redditapp.data.model.HotPosts
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class HomeViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {

    private val _combinedFlow =  MutableStateFlow<UIState> (UIState.Loading)
    val combinedFlow: StateFlow<UIState> = _combinedFlow.asStateFlow()

    init {
        fetchPost()
    }

    fun fetchPost() {

        viewModelScope.launch {
            postRepository.getListOfPost()
                .collect { result ->
                    when (result) {
                        is Result.Success -> {
                            _combinedFlow.value = UIState.Success(result.data)
                        }

                        is Result.Error -> {
                            _combinedFlow.value = UIState.Error(result.exception.message)
                            //_loading.value = false
                           // _error.value = "Error: ${result.exception.message}"
                        }

                        is Result.Loading -> {
                            _combinedFlow.value = UIState.Loading
                        }
                    }
                }
        }
    }
}

sealed class UIState{
    data class Success(val posts: List<HotPosts>) : UIState()
    data class Error(val errorMessage: String?) : UIState()
    object Loading : UIState()
}