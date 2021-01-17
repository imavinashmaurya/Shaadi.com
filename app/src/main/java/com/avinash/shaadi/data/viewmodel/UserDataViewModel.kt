package com.avinash.shaadi.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.avinash.shaadi.data.model.MainResponse
import com.avinash.shaadi.data.model.UserResult
import com.avinash.shaadi.data.repository.UsersRepository


class UserDataViewModel(application: Application) : AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext
    private var usersRepository: UsersRepository? = null

    init {
        usersRepository = UsersRepository.getInstance()
    }

    fun fetchUserData() {
        usersRepository?.fetchUserData()
    }

    fun getUserData(): MutableLiveData<MainResponse>? {
        return usersRepository?.getUserData()
    }

    fun saveUserDataLocally(userData: List<UserResult>) {
        usersRepository?.saveUserDataLocally(userData, context)
    }

    fun updateUserDataLocally(user: UserResult) {
        usersRepository?.updateUserDataLocally(user, context)
    }

    fun getUserDataLocally(): LiveData<List<UserResult>>? {
        return usersRepository?.getUserDataLocally(context)
    }
}