package com.example.mvvm.repository

import com.example.mvvm.repository.model.Product
import com.example.mvvm.repository.source.network.ProductApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsRepository @Inject constructor(
    private val productApi: ProductApi
) {

//    companion object {
//
//        private var instance: ProductsRepository? = null
//
//        fun get(): ProductsRepository {
//            synchronized(this) {
//                if (instance == null) {
//                    instance = ProductsRepository()
//                }
//                return instance!!
//            }
//        }
//
//    }

    suspend fun getProducts(): List<Product> {
        return try {
            val res = productApi.getProducts()
            //Do Transformation
            res.products
        } catch (e: Exception) {
            emptyList()
        }
    }

}