package br.com.myapod.di.module

import br.com.myapod.utils.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
class NetworkModule {

    @Singleton
    @Provides
    fun provideBaseUrl() = checkNotNull(HttpUrl.parse(BASE_URL)) { "BaseUrl is Null" }

    @Singleton
    @Provides
    fun provideRetrofit(httpUrl: HttpUrl): Retrofit =
        Retrofit.Builder()
            .baseUrl(httpUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}