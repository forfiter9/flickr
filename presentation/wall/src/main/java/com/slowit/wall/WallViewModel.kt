package com.slowit.wall

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow

class WallViewModel: ViewModel() {

    private val _state: MutableStateFlow<WallState> = MutableStateFlow(WallState.EMPTY)
    val state: StateFlow<WallState> = _state

    private val _events = Channel<WallEvents>()
    val events = _events.receiveAsFlow()
}