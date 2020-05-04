package br.com.myapod.base

import android.content.Context
import androidx.fragment.app.Fragment
import br.com.myapod.source.usecase.ApodUseCase
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

open class BaseFragment : Fragment() {

    @Inject
    lateinit var apodUseCase: ApodUseCase

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}