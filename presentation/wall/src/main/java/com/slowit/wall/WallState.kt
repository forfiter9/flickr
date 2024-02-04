package com.slowit.wall

data class WallState (
    val posts: List<String>
) {

    companion object {
        val EMPTY =
            WallState(
                posts = emptyList(),
            )
    }
}
