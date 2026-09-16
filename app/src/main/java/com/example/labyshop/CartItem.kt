package com.example.labyshop

data class CartItem(
    val product: Product,
    val variation: VariationItem?,
    val quantity: Int
)
