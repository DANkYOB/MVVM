package com.example.mvvm.repository.flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.mvvm.MainActivityViewModel
import com.example.mvvm.databinding.FragmentFlowBinding
import com.example.mvvm.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FlowFragment: Fragment() {

    private lateinit var binding: FragmentFlowBinding
    private lateinit var vm: FlowFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFlowBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        vm = ViewModelProvider(this)[FlowFragmentViewModel::class.java]

        vm.getProducts()

        viewLifecycleOwner.lifecycleScope.launch {
            vm.collector.collectLatest {
                binding.tv.text = it.toString()
            }
        }

    }

}