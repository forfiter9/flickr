package com.slowit.wall

import com.slowit.model.post.Post

data class WallState (
    val posts: List<Post>
) {

    companion object {
        val EMPTY =
            WallState(
                posts = emptyList(),
            )
    }
}
