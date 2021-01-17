package com.avinash.shaadi.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.avinash.shaadi.data.model.*

@Database(
    entities = [MainResponse::class, UserResult::class, Dob::class, Location::class, Name::class, Picture::class, Registered::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    ResultsConverter::class,
    IdConverter::class,
    DobConverter::class,
    LocationConverter::class,
    NameConverter::class,
    PictureConverter::class,
    RegisteredConverter::class
)
abstract class UserDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: UserDataBase? = null

        fun getUserDataBase(context: Context): UserDataBase {
            if (INSTANCE != null) return INSTANCE!!
            synchronized(this) {
                INSTANCE = Room
                    .databaseBuilder(context, UserDataBase::class.java, "UserDataBaseDB.db")
                    .fallbackToDestructiveMigration()
                    .build()
                return INSTANCE!!
            }
        }
    }
}