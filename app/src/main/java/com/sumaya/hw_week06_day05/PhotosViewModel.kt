package com.sumaya.hw_week06_day05

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class PhotosViewModel: BaseObservable()  {
    var vmPhoto: Results? = null
        set(vmPhoto){
            field = vmPhoto
            notifyChange()
        }

    @get:Bindable
    val id : Int?
        get() = vmPhoto?.id

    @get:Bindable
    val poster : String?
        get() = vmPhoto?.poster_path
    @get:Bindable
    val date : String?
        get() = vmPhoto?.release_date
    @get:Bindable
    val title : String?
        get() = vmPhoto?.title
    @get:Bindable
    val vote : Double?
        get() = vmPhoto?.vote_average
}