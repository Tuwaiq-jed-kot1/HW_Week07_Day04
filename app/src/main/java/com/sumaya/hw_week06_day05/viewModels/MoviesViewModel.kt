package com.sumaya.hw_week07_day04.viewModels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sumaya.hw_week07_day04.network.models.Results

class MoviesViewModel: BaseObservable() {
    var vmMovie: Results? = null
    set(movie){
        field = movie
        notifyChange()
    }
    @get: Bindable
    val id:Int?
        get() = vmMovie?.id

    @get: Bindable
    val poster:String?
        get() = vmMovie?.poster_path

    @get: Bindable
    val date:String?
        get() = vmMovie?.release_date

    @get: Bindable
    val title:String?
        get() = vmMovie?.title

    @get: Bindable
    val rate:Double?
        get() = vmMovie?.vote_average



}

