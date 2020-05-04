package br.com.myapod.di.module

import br.com.myapod.source.remote.api.ApodApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    fun provideApiModule(retrofit: Retrofit): ApodApi =
        retrofit.create(ApodApi::class.java)
}