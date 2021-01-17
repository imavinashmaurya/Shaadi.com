package com.avinash.shaadi.data.model


import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class Registered(
    @NonNull
    @PrimaryKey(autoGenerate = true)
    val idRoom: Int? = 0,
    @SerializedName("age")
    var age: Int? = null, // 8
    @SerializedName("date")
    var date: String? = null // 2013-06-14T09:26:45.556Z
)