package com.example.bookstoreapp.ui.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookstoreapp.data.Repository.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    private val _state = MutableStateFlow(ProductViewState())
    val state: StateFlow<ProductViewState> = _state

    private val repository = BookRepository()

    fun handleIntent(intent: ProductIntent) {
        when (intent) {
            is ProductIntent.LoadProducts -> {
                viewModelScope.launch {
                    loadBooks()
                }
            }
        }
    }

    private suspend fun loadBooks() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        try {
            val books = repository.getBooks()
            _state.value = ProductViewState(isLoading = false, products = books)
        } catch (e: Exception) {
            _state.value = ProductViewState(
                isLoading = false,
                error = e.message ?: "Erreur lors du chargement des livres"
            )
        }
    }
}

