package com.example.bookstoreapp.data.Entities

data class Book(
    val id: String,
    val title: String,
    val author: String,
    val quantity: Int,
    val type: BookType,
    val imageResId: Int
)

enum class BookType {
    DEVELOPPEMENT_PERSONNEL,
    ROMAN
}

