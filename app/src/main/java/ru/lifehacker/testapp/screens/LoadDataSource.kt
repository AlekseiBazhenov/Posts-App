package ru.lifehacker.testapp.screens

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.Response

inline fun <DB, REMOTE> networkBoundResource(
    crossinline fetchFromLocal: () -> Flow<DB>,
    crossinline shouldFetchFromRemote: (DB?) -> Boolean = { true },
    crossinline fetchFromRemote: suspend () -> Response<REMOTE>,
    crossinline processRemoteResponse: (response: Response<REMOTE>) -> Unit = { },
    crossinline saveRemoteData: suspend (REMOTE) -> Unit = { },
    crossinline onFetchFailed: (errorBody: String?, statusCode: Int) -> Unit = { _: String?, _: Int -> }
) = flow<Resource<DB>> {

    emit(Resource.loading(null))

    val localData = fetchFromLocal().first()

    if (shouldFetchFromRemote(localData)) { // todo check max-age

        emit(Resource.loading(localData))

        val apiResponse = fetchFromRemote()
        if (apiResponse.isSuccessful) {

        } else {

        }

//        when (apiResponse) {
//            is ApiSuccessResponse -> {
//                processRemoteResponse(apiResponse)
//                apiResponse.body?.let { saveRemoteData(it) }
//                emitAll(fetchFromLocal().map { dbData ->
//                    Resource.success(dbData)
//                })
//            }
//
//            is ApiErrorResponse -> {
//                onFetchFailed(apiResponse.errorMessage, apiResponse.statusCode)
//                emitAll(fetchFromLocal().map {
//                    Resource.error(apiResponse.errorMessage, it)
//                })
//            }
//            is ApiEmptyResponse -> {
//                Log.d("", "")
//            }
//        }
    } else {
        emitAll(fetchFromLocal().map { Resource.success(it) })
    }
}