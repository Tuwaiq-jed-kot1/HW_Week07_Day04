package com.sumaya.hw_week06_day05

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.tuwaiq.restandretrofit.data.network.models.Results

class VM: BaseObservable() {
    var vmPhoto: Results? =null
        set(photo){
            field= photo
            notifyChange()
        }

    @get: Bindable
    val title:String?
        get() = vmPhoto?.title
    @get: Bindable
    val poster_path:String?
        get() = vmPhoto?.poster_path
    @get: Bindable
    val release_date:String?
        get() = vmPhoto?.release_date
    @get: Bindable
    val vote_average:Double?
        get() = vmPhoto?.vote_average
}