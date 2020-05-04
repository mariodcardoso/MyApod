package br.com.myapod.source.remote.api

import br.com.myapod.BuildConfig
import br.com.myapod.source.remote.response.ApodResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApodApi {

    @GET("${BuildConfig.API_KEY}")
    suspend fun getApod(@Query("date") date: String): ApodResponse

}