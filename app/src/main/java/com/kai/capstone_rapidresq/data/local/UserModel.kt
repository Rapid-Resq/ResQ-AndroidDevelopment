package com.kai.capstone_rapidresq.data.local

data class UserModel(
    val email: String,
    val token: String,
    val isLogin: Boolean = false
)