package com.example.eqtest.data

import android.net.Uri

data class Song(
    val displayName: String = "",
    val author: String = "",
    val duration: String = "",
    val uri: Uri,
)
