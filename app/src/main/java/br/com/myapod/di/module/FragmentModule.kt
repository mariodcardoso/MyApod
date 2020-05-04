package br.com.myapod.di.module

import br.com.myapod.ui.apoddetails.DetailsFragment
import br.com.myapod.ui.apodlist.ListApodFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeListApodFragment(): ListApodFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailsFragment(): DetailsFragment
}
