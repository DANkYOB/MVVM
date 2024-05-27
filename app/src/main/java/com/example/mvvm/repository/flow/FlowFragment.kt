package com.example.mvvm.repository.flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.mvvm.BaseFragment
import com.example.mvvm.MainActivityViewModel
import com.example.mvvm.databinding.FragmentFlowBinding
import com.example.mvvm.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FlowFragment : BaseFragment<FragmentFlowBinding, FlowFragmentViewModel>() {

    override fun getViewBinding(): FragmentFlowBinding {
        return FragmentFlowBinding.inflate(layoutInflater)
    }

    override fun getViewModelClass(): Class<FlowFragmentViewModel> {
        return FlowFragmentViewModel::class.java
    }

    override fun setUpViews() {
        super.setUpViews()

        viewModel.getProducts()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.collector.collectLatest {
                binding.tv.text = it.toString()
            }
        }
    }

}