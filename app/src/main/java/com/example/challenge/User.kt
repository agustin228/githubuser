package com.example.challenge


import android.os.Parcelable
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
