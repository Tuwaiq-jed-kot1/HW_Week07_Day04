package com.sumaya.hw_week07_day04.data.models.vm

import com.google.gson.annotations.SerializedName

data class FlickrData (
    val photos: FlickrListPhotos
)

data class FlickrListPhotos(
    val photo : List<FlickrPhoto>
)
data class FlickrPhoto (
    var title: String,
    @SerializedName("url_s")
    var url: String
)