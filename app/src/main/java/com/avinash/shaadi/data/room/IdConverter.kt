package com.avinash.shaadi.data.room

import androidx.room.TypeConverter
import com.avinash.shaadi.data.model.Id
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class IdConverter {

    /**
     * Convert a object to a Json
     */
    @TypeConverter
    fun fromObjectToJson(stat: Id): String {
        return Gson().toJson(stat)
    }

    /**
     * Convert a json to a object
     */
    @TypeConverter
    fun toObject(json: String): Id {
        val notesType = object : TypeToken<Id>() {}.type
        return Gson().fromJson<Id>(json, notesType)
    }
}