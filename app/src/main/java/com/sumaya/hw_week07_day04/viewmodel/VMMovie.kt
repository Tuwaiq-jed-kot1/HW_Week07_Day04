package com.sumaya.hw_week07_day04.viewmodel

import Results
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable


class VMMovie : BaseObservable(){

    var vmMovie:Results? =null
        set(movies){
            field = movies
            //عشان يقبل تغيرات
            notifyChange()
        }

    @get:Bindable
    val title :String?
        get() = vmMovie?.title

    @get:Bindable
    val posterPath :String?
        get() = vmMovie?.poster_path

    @get:Bindable
    val voteAverage :Double?
        get() = vmMovie?.vote_average

    @get:Bindable
    val releaseDate :String?
        get() = vmMovie?.release_date
}