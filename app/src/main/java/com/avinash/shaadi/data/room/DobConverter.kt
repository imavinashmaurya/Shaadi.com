package com.avinash.shaadi.data.room

import androidx.room.TypeConverter
import com.avinash.shaadi.data.model.Dob
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class DobConverter {

    /**
     * Convert a object to a Json
     */
    @TypeConverter
    fun fromObjectToJson(stat: Dob): String {
        return Gson().toJson(stat)
    }

    /**
     * Convert a json to a object
     */
    @TypeConverter
    fun toObject(json: String): Dob {
        val notesType = object : TypeToken<Dob>() {}.type
        return Gson().fromJson<Dob>(json, notesType)
    }
}