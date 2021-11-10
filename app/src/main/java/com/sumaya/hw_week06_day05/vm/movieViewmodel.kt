package com.sumaya.hw_week06_day05.vm

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sumaya.hw_week06_day05.Data.Data
import com.sumaya.hw_week06_day05.Data.Results

class movieViewmodel :BaseObservable() {
    var vmMovie:Results?=null
    set(movie){
        field =movie
        notifyChange()
    }
 @get:Bindable
val title:String?
get() =vmMovie?.title

    val  id:Int?
        get() =vmMovie?.id

    val release_date:String?
    get() = vmMovie?.release_date

    val vote_average:String?
    get()= vmMovie?.vote_average


}