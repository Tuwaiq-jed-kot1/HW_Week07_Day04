package com.sumaya.hw_week07_day04.data.network

import com.sumaya.hw_week07_day04.data.modle.DbData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepoDB {
    private val api = DbBuilder.DbApi

    suspend fun viewMoviesInfo(): DbData = withContext(Dispatchers.IO) {
        api.viewMoviesInfo()
    }

    suspend fun searchMovies(searchKeyWord: String): DbData = withContext(Dispatchers.IO) {
        api.searchMovies(searchKeyWord)
    }
}