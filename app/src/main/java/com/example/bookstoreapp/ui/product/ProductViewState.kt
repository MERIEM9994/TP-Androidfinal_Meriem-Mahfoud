package com.example.bookstoreapp.ui.product

import com.example.bookstoreapp.data.Entities.Book

data class ProductViewState(
    val isLoading: Boolean = false,
    val books: List<Book> = emptyList(),
    val selectedBook: Book? = null,
    val error: String? = null
)
