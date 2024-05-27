package com.example.mvvm.repository.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.repository.ProductsRepository
import com.example.mvvm.repository.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(): ViewModel() {

    @Inject
    lateinit var productsRepository: ProductsRepository

    val textLiveData: MutableLiveData<String?> = MutableLiveData()
    val productsLiveData: MutableLiveData<List<Product>> = MutableLiveData()

    /**
     * Sending Data back to UIs
     * 1. LiveData
     * 2. Kotlin Flow
     */

    /**
     * LiveData - PostValue - Call from Background Thread, SetValue - Call From Main Thread
     */

    /**
     * Data Sources (Can be multiple) (Remote, Database)
     * Repository
     *
     * ViewModel
     *
     *
     */

    fun getProducts() {
        if (productsLiveData.value != null) {
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            val products = productsRepository.getProducts()
            productsLiveData.postValue(products)
        }
    }

    fun setText(text: String?) {
        textLiveData.value = text
    }

}