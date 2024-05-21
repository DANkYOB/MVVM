package com.example.mvvm.repository.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.FragmentOneBinding

class Fragment1 : Fragment() {

    private lateinit var binding: FragmentOneBinding
    private val vm by lazy {
        ViewModelProvider(parentFragment as HomeFragment)[HomeFragmentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn.setOnClickListener {

            val text = binding.et.text?.toString()?.trim()
            vm.setText(text)

        }

    }

}