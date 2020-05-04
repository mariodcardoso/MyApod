package br.com.myapod.source

import br.com.myapod.source.remote.response.ApodResponse

interface ApodSource {
    suspend fun getApod(date: String): ApodResponse
}