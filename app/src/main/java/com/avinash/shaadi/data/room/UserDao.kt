package com.avinash.shaadi.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.avinash.shaadi.data.model.UserResult

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserData(userData: List<UserResult>): List<Long>

    @Query("SELECT * FROM UserTable")
    fun getAllUser(): LiveData<List<UserResult>>

    @Update(entity = UserResult::class)
    fun updateUser(user: UserResult)
}