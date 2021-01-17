package com.avinash.shaadi.data.model


import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.avinash.shaadi.data.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "UserTable")
data class UserResult(
    @NonNull
    @PrimaryKey()
    @SerializedName("cell")
    var cell: String, // 29412627
    @TypeConverters(DobConverter::class)
    @SerializedName("dob")
    var dob: Dob? = null,
    @SerializedName("email")
    var email: String? = null, // isabella.christensen@example.com
    @SerializedName("gender")
    var gender: String? = null, // female
    @TypeConverters(IdConverter::class)
    @SerializedName("id")
    var id: Id?=null,
    @TypeConverters(LocationConverter::class)
    @SerializedName("location")
    var location: Location? = null,
    @TypeConverters(NameConverter::class)
    @SerializedName("name")
    var name: Name? = null,
    @SerializedName("nat")
    var nat: String? = null, // DK
    @SerializedName("phone")
    var phone: String? = null, // 49783894
    @TypeConverters(PictureConverter::class)
    @SerializedName("picture")
    var picture: Picture? = null,
    @TypeConverters(RegisteredConverter::class)
    @SerializedName("registered")
    var registered: Registered? = null,
    @ColumnInfo(name = "acceptedDecline")
    var acceptedDecline: Boolean? = null
)