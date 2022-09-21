package com.example.challenge

import android.location.Location
import android.os.Parcelable
import android.provider.ContactsContract
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var username : String,
    var name : String,
    var company : String,
    var photo: Int,
    var location: String,
    var repository: String,
    var following: String,
    var followers: String
) :Parcelable
