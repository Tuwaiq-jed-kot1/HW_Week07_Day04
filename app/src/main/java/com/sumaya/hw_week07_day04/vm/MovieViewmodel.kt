package com.sumaya.hw_week07_day04.vm

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sumaya.hw_week07_day04.Results

class MovieViewmodel :BaseObservable() {
    var vmMovie: Results?=null
    set(movie){
        field =movie
        notifyChange()
    }
 @get:Bindable
val title:String?
get() =vmMovie?.title

    @get:Bindable
    val  id:Int?
        get() =vmMovie?.id

    @get:Bindable
    val release_date:String?
    get() = vmMovie?.release_date

    @get:Bindable
    val vote_average:String?
    get()= vmMovie?.vote_average


}