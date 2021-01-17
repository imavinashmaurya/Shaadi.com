package com.avinash.shaadi.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.avinash.shaadi.api.APICalling
import com.avinash.shaadi.data.model.MainResponse
import com.avinash.shaadi.data.model.UserResult
import com.avinash.shaadi.data.room.UserDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersRepository {

    companion object {
        private val mInstance = UsersRepository()
        fun getInstance(): UsersRepository {
            return mInstance
        }
    }

    private var userData: MutableLiveData<MainResponse> = MutableLiveData()

    fun fetchUserData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = APICalling.apiCall()
                    .getUserData()
                if (response.isSuccessful) {
                    userData.postValue(response.body())
                }
            } catch (e: Throwable) {
            }
        }
    }

    fun getUserData(): MutableLiveData<MainResponse> {
        return userData
    }

    private fun getDataBase(context: Context): UserDataBase {
        return UserDataBase.getUserDataBase(context)
    }

    fun saveUserDataLocally(userData: List<UserResult>, context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            val dataBase = getDataBase(context)
            dataBase.userDao().insertUserData(userData)
        }
    }

    fun updateUserDataLocally(user: UserResult, context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            val dataBase = getDataBase(context)
            dataBase.userDao().updateUser(user)
        }
    }

    fun getUserDataLocally(context: Context): LiveData<List<UserResult>> {
        val dataBase = getDataBase(context)
        return dataBase.userDao().getAllUser()
    }
}