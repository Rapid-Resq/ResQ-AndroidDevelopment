package com.kai.capstone_rapidresq.data.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val image: String,
    val title: String,
    val location: String,
    val description: String,
):Parcelable