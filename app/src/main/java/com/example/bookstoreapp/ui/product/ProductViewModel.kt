package com.example.bookstoreapp.ui.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookstoreapp.data.Entities.Book
import com.example.bookstoreapp.data.Repository.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductViewModel(
    private val repository: BookRepository = BookRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(ProductViewState())
    val state: StateFlow<ProductViewState> = _state

    fun getBookById(bookId: String): Book? = _state.value.books.find { it.id == bookId }

    fun handleIntent(intent: ProductIntent) {
        when (intent) {
            ProductIntent.LoadBooks -> loadBooks()
            is ProductIntent.ShowBookDetails -> updateSelectedBook(intent.bookId)
            ProductIntent.NavigateBack -> clearSelectedBook()
        }
    }

    private fun loadBooks() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }

            try {
                val books = repository.getBooks()
                _state.update {
                    it.copy(
                        isLoading = false,
                        books = books,
                        selectedBook = null
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Erreur de chargement"
                    )
                }
            }
        }
    }

    private fun updateSelectedBook(bookId: String) {
        _state.update { currentState ->
            currentState.copy(
                selectedBook = currentState.books.find { it.id == bookId }
            )
        }
    }

    private fun clearSelectedBook() {
        _state.update { it.copy(selectedBook = null) }
    }
}