package com.avinash.shaadi.data.room

import androidx.room.TypeConverter
import com.avinash.shaadi.data.model.Dob
import com.avinash.shaadi.data.model.Location
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class LocationConverter {

    /**
     * Convert a object to a Json
     */
    @TypeConverter
    fun fromObjectToJson(stat: Location): String {
        return Gson().toJson(stat)
    }

    /**
     * Convert a json to a object
     */
    @TypeConverter
    fun toObject(json: String): Location {
        val notesType = object : TypeToken<Location>() {}.type
        return Gson().fromJson<Location>(json, notesType)
    }
}