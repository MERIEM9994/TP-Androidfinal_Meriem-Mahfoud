package com.example.bookstoreapp.ui.products.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bookstoreapp.data.Entities.Book

@Composable
fun BooksList(books: List<Book>, onNavigateToDetails: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(books) { book ->
            BookItem(book, onNavigateToDetails)
        }
    }
}
