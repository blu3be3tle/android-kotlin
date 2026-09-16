package com.example.labyshop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(
    private val repository: ProductRepository
) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        loadProducts()
    }

    fun loadProducts() {

        viewModelScope.launch {

            try {

                _error.value = null

                val result = repository.getProducts()

                _products.value = result

            } catch (e: Exception) {

                _error.value = e.localizedMessage ?: "Something went wrong"

                e.printStackTrace()
            }
        }
    }
}