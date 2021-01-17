package com.avinash.shaadi.data.room

import androidx.room.TypeConverter
import com.avinash.shaadi.data.model.UserResult
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*


class ResultsConverter {

    /**
     * Convert a object to a Json
     */
    @TypeConverter
    fun fromObjectToJson(stat: List<UserResult>): String {
        return Gson().toJson(stat)
    }

    /**
     * Convert a json to a object
     */
    @TypeConverter
    fun toObject(json: String): List<UserResult> {
        val notesType = object : TypeToken<List<UserResult>>() {}.type
        return Gson().fromJson<List<UserResult>>(json, notesType)
    }
}