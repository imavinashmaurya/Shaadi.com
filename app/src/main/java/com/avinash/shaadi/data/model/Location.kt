package com.avinash.shaadi.data.model


import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Location(
    @NonNull
    @PrimaryKey(autoGenerate = true)
    val idRoom: Int? = 0,
    @SerializedName("city")
    var city: String? = null, // Lundby
    @SerializedName("country")
    var country: String? = null, // Denmark
    @SerializedName("state")
    var state: String? = null// Hovedstaden

)