package com.example.mvvm.repository

import com.example.mvvm.repository.source.APIs
import com.example.mvvm.repository.model.Product
import java.lang.Exception

class ProductsRepository {

    suspend fun getProducts(): List<Product> {
        return try {
            val res = APIs.productApi.getProducts()
            //Do Transformation
            res.products
        } catch (e: Exception) {
            emptyList()
        }
    }

}