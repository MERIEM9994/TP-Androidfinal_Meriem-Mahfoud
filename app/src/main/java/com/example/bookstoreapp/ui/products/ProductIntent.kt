package com.example.bookstoreapp.ui.products

// Intent = intention utilisateur
sealed class ProductIntent {
    object LoadProducts : ProductIntent()
}
