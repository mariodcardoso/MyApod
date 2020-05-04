package br.com.myapod.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApodResponse(
    val copyright: String,
    val title: String,
    val date: String,
    val explanation: String,
    val url: String,
    @SerializedName("media_type")
    val mediaType: String
) : Parcelable