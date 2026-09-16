package com.example.labyshop

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Product(
    val id: Int,
    val title: String = "",
    val url: String = "",
    val price: Price? = null,
    val brand: String? = null,
    val image: ProductImage? = null,
    @SerialName("stock_quantity")
    val stockQuantity: Int = 0,
    val origin: Origin? = null
)

@Serializable
data class Price(
    @SerialName("price_method")
    val priceMethod: String = "",

    @SerialName("single_price")
    val singlePrice: SinglePrice? = null,

    @SerialName("variation_price")
    val variationPrice: VariationPrice? = null,
)

@Serializable
data class Origin(
    val code: String? = null,
    val name: String? = null,
)

@Serializable
data class SinglePrice(
    val mrp: Double = 0.0,
    val sale: Double = 0.0,

    @SerialName("active_price")
    val activePrice: Double = 0.0,
)

@Serializable
data class VariationPrice(
    val prices: List<VariationItem> = emptyList()
)

@Serializable
data class VariationItem(
    val mrp: Double = 0.0,
    val sale: Double = 0.0,

    @SerialName("active_price")
    val activePrice: Double = 0.0,

    @SerialName("is_available")
    val isAvailable: Boolean = false,

    @SerialName("title_suffix")
    val titleSuffix: String = "",
)


@Serializable
data class ProductImage(
    @SerialName("original")
    val original: String? = null,

    val thumbnail: String? = null,
    val small: String? = null,
    val medium: String? = null,
    val large: String? = null,
)