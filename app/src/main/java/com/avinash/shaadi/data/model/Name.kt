package com.avinash.shaadi.data.model


import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class Name(
    @NonNull
    @PrimaryKey(autoGenerate = true)
    val idRoom: Int? = 0,
    @SerializedName("first")
    var first: String? = null, // Isabella
    @SerializedName("last")
    var last: String? = null, // Christensen
    @SerializedName("title")
    var title: String? = null // Mrs
)