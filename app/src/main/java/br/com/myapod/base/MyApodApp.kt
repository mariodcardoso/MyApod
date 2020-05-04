package br.com.myapod.base

import android.app.Application
import br.com.myapod.di.component.DaggerAppComponent
import br.com.myapod.di.module.AppModule
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApodApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector() = androidInjector

    override fun onCreate() {
        super.onCreate()

        val application = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()

        application.inject(this)

    }


}