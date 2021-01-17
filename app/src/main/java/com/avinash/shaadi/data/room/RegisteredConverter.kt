package com.avinash.shaadi.data.room

import androidx.room.TypeConverter
import com.avinash.shaadi.data.model.Registered
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class RegisteredConverter {

    /**
     * Convert a object to a Json
     */
    @TypeConverter
    fun fromObjectToJson(stat: Registered): String {
        return Gson().toJson(stat)
    }

    /**
     * Convert a json to a object
     */
    @TypeConverter
    fun toObject(json: String): Registered {
        val notesType = object : TypeToken<Registered>() {}.type
        return Gson().fromJson<Registered>(json, notesType)
    }
}