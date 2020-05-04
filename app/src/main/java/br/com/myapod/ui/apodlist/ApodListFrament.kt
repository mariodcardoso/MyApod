package br.com.myapod.ui.apodlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.myapod.base.BaseFragment
import br.com.myapod.databinding.FragmentApodListBinding
import br.com.myapod.source.remote.response.ApodResponse
import br.com.myapod.ui.apodlist.viewmodel.ListApodViewModel
import br.com.myapod.ui.apodlist.viewmodel.ListApodViewModelFactory

class ListApodFragment : BaseFragment(), ApodAdapter.OnApodListener {

    private val binding by lazy { FragmentApodListBinding.inflate(layoutInflater) }

    val factory by lazy { ListApodViewModelFactory(apodUseCase) }
    private lateinit var viewModel: ListApodViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity(), factory).get(ListApodViewModel::class.java)
        lifecycle.addObserver(viewModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateView()

    }

    private fun updateView() {
        viewModel.getLisApod.observe(this, Observer {
            binding.rcvApodList.apply {
                val apodAdapter = ApodAdapter(requireContext(), it, this@ListApodFragment)
                adapter = apodAdapter
                layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
            }
        })
    }

    override fun onApodClick(apodItem: ApodResponse) {
        val actionApod = ListApodFragmentDirections.actionListApodFragmentToDetailsFragment(apodItem)
        findNavController().navigate(actionApod)
    }
}