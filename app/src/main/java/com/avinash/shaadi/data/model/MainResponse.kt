package com.avinash.shaadi.data.model


import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.avinash.shaadi.data.room.ResultsConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "MainTable")
data class MainResponse(
    @NonNull
    @PrimaryKey(autoGenerate = true)
    val idRoom: Int? = 0,
    @TypeConverters(ResultsConverter::class)
    @SerializedName("results")
    var results: List<UserResult>? = null
)