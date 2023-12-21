package com.kai.capstone_rapidresq.data.response

data class LoginResponse (
    val success: Boolean,
    val loginResult: LoginResult
)

data class LoginResult(
    val token: String
)