package com.example.mvvm.repository.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.MainActivityViewModel
import com.example.mvvm.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeFragmentViewModel: HomeFragmentViewModel
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        homeFragmentViewModel = ViewModelProvider(this)[HomeFragmentViewModel::class.java]
        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

//        homeFragmentViewModel.getProducts()
//        homeFragmentViewModel.productsLiveData.observe(viewLifecycleOwner) {
//            binding.tv.text = it.toString()
//        }



    }

}