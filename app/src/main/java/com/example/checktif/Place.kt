package com.example.checktif

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Place (
    val placeName: String,
    val placeAddress: String,
    val placeImages: Int,
    val placeDescription: String,
    val placeFullAddress: String,
    val placeTicket: String,
): Parcelable

