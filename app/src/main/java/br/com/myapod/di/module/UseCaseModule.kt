package br.com.myapod.di.module

import br.com.myapod.source.ApodRepository
import br.com.myapod.source.usecase.ApodUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideUseCaseModule(apodRepository: ApodRepository) = ApodUseCase(apodRepository)

}