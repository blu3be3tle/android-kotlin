package com.example.labyshop

class ProductRepository(
    private val api: ProductAPI
) {

    suspend fun getProducts(): List<Product> {
        return api.getProducts().data
    }
}