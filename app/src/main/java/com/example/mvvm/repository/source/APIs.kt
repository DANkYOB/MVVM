package com.example.mvvm.repository.source

import com.example.mvvm.repository.source.network.ProductApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIs {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val productApi = retrofit.create(ProductApi::class.java)

}