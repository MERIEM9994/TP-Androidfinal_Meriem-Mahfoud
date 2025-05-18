package com.example.bookstoreapp.ui.products

import com.example.bookstoreapp.data.Entities.Book

data class ProductViewState(
    val isLoading: Boolean = false,
    val products: List<Book> = emptyList(),
    val error: String? = null
)

