package br.com.myapod.ui.apodlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.myapod.source.usecase.ApodUseCase

class ListApodViewModelFactory(
    private val apodUseCase: ApodUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListApodViewModel::class.java)) {
            return ListApodViewModel(apodUseCase) as T
        }
        throw IllegalArgumentException("View Model Unknown")

    }
}