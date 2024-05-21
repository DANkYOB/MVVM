package com.example.mvvm.repository.model

data class Product(
    val id: String,
    val title: String
)

data class Products(
    val products: List<Product>
)
