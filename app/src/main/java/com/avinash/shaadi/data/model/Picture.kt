package com.avinash.shaadi.data.model


import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class Picture(
    @NonNull
    @PrimaryKey(autoGenerate = true)
    val idRoom: Int? = 0,
    @SerializedName("large")
    var large: String? = null, // https://randomuser.me/api/portraits/women/16.jpg
    @SerializedName("medium")
    var medium: String? = null, // https://randomuser.me/api/portraits/med/women/16.jpg
    @SerializedName("thumbnail")
    var thumbnail: String? = null // https://randomuser.me/api/portraits/thumb/women/16.jpg
)