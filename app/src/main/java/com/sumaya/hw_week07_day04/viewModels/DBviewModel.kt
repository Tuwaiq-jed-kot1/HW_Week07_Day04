package com.sumaya.hw_week07_day04.viewModels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sumaya.hw_week07_day04.data.modle.Results

class DBviewModel: BaseObservable() {
    var vmDB: Results? = null
        set(vmDB){
            field = vmDB
            notifyChange()
        }

    @get:Bindable
    val title : String?
        get() = vmDB?.title

    @get:Bindable
    val data : String?
        get() = vmDB?.release_date
    @get:Bindable
    val vote_average : String?
        get() = vmDB?.vote_average.toString()
}