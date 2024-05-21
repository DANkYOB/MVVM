package com.example.mvvm.repository.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.FragmentOneBinding
import com.example.mvvm.databinding.FragmentTwoBinding

class Fragment2 : Fragment() {

    private lateinit var binding: FragmentTwoBinding
    private val vm by lazy {
        ViewModelProvider(parentFragment as HomeFragment)[HomeFragmentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.textLiveData.observe(viewLifecycleOwner) {
            binding.tv.text = it
        }

    }

}