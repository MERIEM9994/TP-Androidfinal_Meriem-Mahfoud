package com.example.bookstoreapp.data.Entities

data class Book(
    val id: String,
    val title: String,
    val author: String,
    val quantity: Int,
    val type: BookType,
    val imageResId: Int,
    val publishedYear: Int? = null // Nouveau champ pour l'année de publication
)

enum class BookType {
    ROMAN,
    POESIE,
    THEATRE,
    ESSAI,
    HISTOIRE
}


