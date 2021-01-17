package com.avinash.shaadi.data.model


import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class Id(
    @NonNull
    @PrimaryKey(autoGenerate = true)
    val idRoom: Int? = 0,
    @SerializedName("name")
    var name: String? = null, // CPR
    @SerializedName("value")
    var value: String? = null // 010872-1531
)