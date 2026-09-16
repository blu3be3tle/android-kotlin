package com.example.labyshop

import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    val success: Boolean,
    val data: List<Product>
)