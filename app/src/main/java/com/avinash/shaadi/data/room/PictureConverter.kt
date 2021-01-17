package com.avinash.shaadi.data.room

import androidx.room.TypeConverter
import com.avinash.shaadi.data.model.Dob
import com.avinash.shaadi.data.model.Name
import com.avinash.shaadi.data.model.Picture
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class PictureConverter {

    /**
     * Convert a object to a Json
     */
    @TypeConverter
    fun fromObjectToJson(stat: Picture): String {
        return Gson().toJson(stat)
    }

    /**
     * Convert a json to a object
     */
    @TypeConverter
    fun toObject(json: String): Picture {
        val notesType = object : TypeToken<Picture>() {}.type
        return Gson().fromJson<Picture>(json, notesType)
    }
}