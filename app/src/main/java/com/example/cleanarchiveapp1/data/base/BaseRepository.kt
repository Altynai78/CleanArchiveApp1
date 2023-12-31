package com.example.cleanarchiveapp1.data.base

import kotlinx.coroutines.flow.internal.NopCollector.emit

abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "unknown error"))
        }
    }
}