package br.com.myapod.source.remote.api

import br.com.myapod.source.remote.response.ApodResponse
import br.com.myapod.utils.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApodApi {

    @GET(API_KEY)
    suspend fun getApod(@Query("date") date: String): ApodResponse

}