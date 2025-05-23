package com.example.bookstoreapp.data.Repository

import com.example.bookstoreapp.data.Entities.Book
import com.example.bookstoreapp.data.Entities.BookType
import com.example.bookstoreapp.R
import kotlinx.coroutines.delay

class BookRepository {
    suspend fun getBooks(): List<Book> {
        delay(1000)
        return listOf(
            Book("1", "Les Misérables", "Victor Hugo", 8, BookType.ROMAN, R.drawable.miserables),
            Book("2", "Notre-Dame de Paris", "Victor Hugo", 9, BookType.ROMAN, R.drawable.notredame),
            Book("3", "Les Contemplations", "Victor Hugo", 10, BookType.POESIE, R.drawable.contemplations),
            Book("4", "Le Dernier Jour d'un Condamné", "Victor Hugo", 11, BookType.ROMAN, R.drawable.condamne),
            Book("5", "Les Travailleurs de la Mer", "Victor Hugo", 19, BookType.ROMAN, R.drawable.travailleurs),
            Book("6", "Han d'Islande", "Victor Hugo", 28, BookType.ROMAN, R.drawable.hanislande)
        )
    }
}

