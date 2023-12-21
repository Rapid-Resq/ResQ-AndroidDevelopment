package com.kai.capstone_rapidresq.data.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DummyUser(
    val id: Int,
    val profilePhoto: String,
    val nama: String,
    val birthDate: String,
    val email: String,
    val password: String,
    val address: String,
    val gender: String,
    val bpjs: Int,
    val job: String,
    val phoneNumber: Long,
    val ktp: Long
): Parcelable