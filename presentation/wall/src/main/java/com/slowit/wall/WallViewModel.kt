package com.slowit.wall

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slowit.usecase.GetSortedPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WallViewModel @Inject constructor(
    private val getSortedPostsUseCase: GetSortedPostsUseCase
): ViewModel() {

    private val _state: MutableStateFlow<WallState> = MutableStateFlow(WallState.EMPTY)
    val state: StateFlow<WallState> = _state

    fun getPosts() = viewModelScope.launch {
        val postList = getSortedPostsUseCase.invoke()
        _state.value = _state.value.copy(
            posts = postList
        )
    }
}