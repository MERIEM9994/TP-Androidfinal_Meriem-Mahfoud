package com.example.bookstoreapp.ui.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookstoreapp.data.Repository.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(
    private val repository: BookRepository = BookRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(ProductViewState())
    val state: StateFlow<ProductViewState> = _state

    fun handleIntent(intent: ProductIntent) {
        when (intent) {
            ProductIntent.LoadBooks -> loadBooks()
            is ProductIntent.ShowBookDetails -> showDetails(intent.bookId)
            ProductIntent.NavigateBack -> navigateBack()
        }
    }

    private fun loadBooks() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                val books = repository.getBooks()
                _state.value = _state.value.copy(
                    isLoading = false,
                    books = books,
                    error = null
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.message ?: "Error loading books"
                )
            }
        }
    }

    private fun showDetails(bookId: String) {
        _state.value.run {
            val book = books.find { it.id == bookId }
            _state.value = this.copy(selectedBook = book)
        }
    }

    private fun navigateBack() {
        _state.value = _state.value.copy(selectedBook = null)
    }
}

