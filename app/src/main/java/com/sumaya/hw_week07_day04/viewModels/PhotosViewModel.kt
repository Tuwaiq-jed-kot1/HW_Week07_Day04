package com.shady.restandretrofit.data.viewModels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sumaya.hw_week06_day05.Results

class PhotosViewModel : BaseObservable() {
    var vmMovie: Results? =null
        set(movies){
            field = movies
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
