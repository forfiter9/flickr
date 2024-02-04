package com.slowit.model.rest

import com.google.gson.annotations.SerializedName

data class Media (
    @SerializedName("m")
    val imageLink: String?
)