package com.kai.capstone_rapidresq.data.response

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.kai.capstone_rapidresq.data.api.Result
import com.kai.capstone_rapidresq.data.local.UserModel
import com.kai.capstone_rapidresq.data.local.UserPreference
import com.kai.capstone_rapidresq.data.local.dataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class Repository(private val context: Context) {

    suspend fun register(
        name: String,
        email: String,
        password: String
    ): LiveData<Result<RegisterResponse>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)
        try {
            val dummyResponse = RegisterResponse(success = true)
            emit(Result.Success(dummyResponse))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

    suspend fun login(
        email: String,
        password: String
    ): LiveData<Result<LoginResponse>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)
        try {
            val dummyToken = "dummy_token"
            saveSession(UserModel(email, dummyToken))
            val dummyResponse = LoginResponse(success = true, loginResult = LoginResult(dummyToken))
            emit(Result.Success(dummyResponse))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

    private suspend fun saveSession(user: UserModel) {
        UserPreference.getInstance(context.dataStore).saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return UserPreference.getInstance(context.dataStore).getSession()
    }

    suspend fun logout() {
        UserPreference.getInstance(context.dataStore).logout()
    }
}
