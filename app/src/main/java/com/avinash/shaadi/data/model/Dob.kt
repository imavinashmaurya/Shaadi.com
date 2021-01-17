package com.avinash.shaadi.data.model


import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Dob(
    @NonNull
    @PrimaryKey(autoGenerate = true)
    val idRoom: Int? = 0,
    @SerializedName("age")
    var age: Int? = null, // 49
    @SerializedName("date")
    var date: String? = null // 1972-08-01T07:23:42.507Z
)