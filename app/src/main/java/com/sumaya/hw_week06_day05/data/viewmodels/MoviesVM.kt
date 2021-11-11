package com.sumaya.hw_week06_day05.data.viewmodels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sumaya.hw_week06_day05.data.modules.Results

class MoviesVM: BaseObservable() {
    var movieVM: Results? =null
        set(vmMovie) {
            field=vmMovie
            notifyChange()
        }

    @get:Bindable
    val title:String?
        get() = movieVM?.title

    @get:Bindable
    val votes:String?
        get() = movieVM?.vote_average.toString()

    @get:Bindable
    val date :String?
        get() = movieVM?.release_date
}

