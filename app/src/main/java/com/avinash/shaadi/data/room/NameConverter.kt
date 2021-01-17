package com.avinash.shaadi.data.room

import androidx.room.TypeConverter
import com.avinash.shaadi.data.model.Dob
import com.avinash.shaadi.data.model.Name
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class NameConverter {

    /**
     * Convert a object to a Json
     */
    @TypeConverter
    fun fromObjectToJson(stat: Name): String {
        return Gson().toJson(stat)
    }

    /**
     * Convert a json to a object
     */
    @TypeConverter
    fun toObject(json: String): Name {
        val notesType = object : TypeToken<Name>() {}.type
        return Gson().fromJson<Name>(json, notesType)
    }
}