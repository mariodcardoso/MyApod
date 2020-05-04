package br.com.myapod.ui.apodlist.viewmodel

import androidx.lifecycle.liveData
import br.com.myapod.base.BaseViewModel
import br.com.myapod.source.usecase.ApodUseCase
import kotlinx.coroutines.Dispatchers

class ListApodViewModel(apodUseCase: ApodUseCase) : BaseViewModel() {

    val getLisApod = liveData(Dispatchers.IO) {
        val getList = apodUseCase.getApodList()

        emit(getList)
    }

}