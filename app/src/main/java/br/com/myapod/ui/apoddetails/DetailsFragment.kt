package br.com.myapod.ui.apoddetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.findNavController
import br.com.myapod.R
import br.com.myapod.base.BaseFragment
import br.com.myapod.databinding.FragmentDetailsStartBinding
import com.bumptech.glide.Glide

class DetailsFragment : BaseFragment() {

    private val binding by lazy { FragmentDetailsStartBinding.inflate(layoutInflater) }

    private val apodItem by lazy {
        arguments?.let {
            DetailsFragmentArgs.fromBundle(it).apodResponse
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDateRange.setOnClickListener {
            findNavController(this).navigate(R.id.action_detailsFragment_to_listApodFragment)
        }

        bindInfo()
    }

    private fun bindInfo() {
        apodItem?.let {
            binding.apply {
                txtTitle.text = it.title
                txtDescription.text = it.explanation
                txtCopyright.text = if (it.copyright.isNullOrEmpty()) "NASA" else it.copyright
                txtDate.text = it.date
                Glide.with(requireContext()).load(it.url).into(binding.imgApod)
            }
        }
    }
}