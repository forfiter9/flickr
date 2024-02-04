package com.slowit.wall

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slowit.usecase.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class WallViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
): ViewModel() {

    private val _state: MutableStateFlow<WallState> = MutableStateFlow(WallState.EMPTY)
    val state: StateFlow<WallState> = _state

    private val _events = Channel<WallEvents>()
    val events = _events.receiveAsFlow()

    fun getPosts() = viewModelScope.launch {
        val list = getPostsUseCase.invoke()
        Log.e("Posts", "getPosts: $list", )
    }
}