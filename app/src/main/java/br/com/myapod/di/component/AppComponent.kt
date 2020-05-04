package br.com.myapod.di.component

import br.com.myapod.base.MyApodApp
import br.com.myapod.di.module.ActivityModule
import br.com.myapod.di.module.AppModule
import br.com.myapod.di.module.FragmentModule
import br.com.myapod.di.module.NetworkModule
import br.com.myapod.di.module.UseCaseModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ActivityModule::class,
        FragmentModule::class,
        AndroidInjectionModule::class,
        NetworkModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent : AndroidInjector<MyApodApp>