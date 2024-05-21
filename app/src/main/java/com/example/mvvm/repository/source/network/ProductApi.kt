package com.example.mvvm.repository.source.network

import com.example.mvvm.repository.model.Products
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getProducts(): Products

}