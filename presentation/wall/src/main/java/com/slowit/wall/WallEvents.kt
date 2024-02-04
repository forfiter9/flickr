package com.slowit.wall

sealed class WallEvents {
    data class OpenExternalLink(val link: String): WallEvents()
}