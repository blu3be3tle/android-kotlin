package com.example.labyshop

import retrofit2.http.GET

interface ProductAPI {

    @GET("api/v1/product/new-arrivals/")
    suspend fun getProducts(): ProductResponse
}