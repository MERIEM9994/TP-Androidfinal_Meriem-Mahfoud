package com.example.bookstoreapp.ui.product.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookstoreapp.ui.product.ProductIntent
import com.example.bookstoreapp.ui.product.ProductViewModel
import com.example.bookstoreapp.ui.product.component.ProductsList

@Composable
fun HomeScreen(
    viewModel: ProductViewModel = viewModel(),
    onBookClick: (String) -> Unit
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.handleIntent(ProductIntent.LoadBooks)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when {
            state.isLoading -> CircularProgressIndicator()
            state.error != null -> Text("Erreur: ${state.error}", color = Color.Red)
            else -> ProductsList(books = state.books, onBookClick = onBookClick)
        }
    }
}