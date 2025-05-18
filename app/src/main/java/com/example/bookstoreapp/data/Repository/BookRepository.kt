package com.example.bookstoreapp.data.Repository
import com.example.bookstoreapp.data.Entities.Book
import com.example.bookstoreapp.data.Entities.BookType
import com.example.bookstoreapp.R
import kotlinx.coroutines.delay


class BookRepository {
    suspend fun getBooks(): List<Book> {
        delay(1000) // Simule un appel réseau ou base de données
        return listOf(
            Book("1", "Les 7 habitudes de ceux qui réussissent tout ce qu’ils entreprennent", "Stephen R. Covey", 5, BookType.DEVELOPPEMENT_PERSONNEL, R.drawable.book1),
            Book("2", "L’Alchimiste", "Paulo Coelho", 2, BookType.ROMAN, R.drawable.book2),
            Book("3", "Père riche, père pauvre", "Robert Kiyosaki", 4, BookType.DEVELOPPEMENT_PERSONNEL, R.drawable.book3),
            Book("4", "Le Petit Prince", "Antoine de Saint-Exupéry", 3, BookType.ROMAN, R.drawable.book4),
            Book("5", "Deep Work", "Cal Newport", 6, BookType.DEVELOPPEMENT_PERSONNEL, R.drawable.book5)
        )
    }
}
