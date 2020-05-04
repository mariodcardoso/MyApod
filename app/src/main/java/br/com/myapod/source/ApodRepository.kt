package br.com.myapod.source

import br.com.myapod.source.remote.api.ApodApi
import br.com.myapod.source.remote.response.ApodResponse
import javax.inject.Inject

class ApodRepository @Inject constructor(
    private val apodApi: ApodApi
) : ApodSource {

    override suspend fun getApod(date: String)= apodApi.getApod(date)


}