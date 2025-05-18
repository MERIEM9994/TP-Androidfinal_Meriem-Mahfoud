package com.example.bookstoreapp.ui.products.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bookstoreapp.data.Entities.Book

@Composable
fun BookItem(book: Book, onNavigateToDetails: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = book.imageResId),
                contentDescription = "Image du livre",
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 8.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Titre : ${book.title}")
                Text(text = "Auteur : ${book.author}")
                Spacer(modifier = Modifier.height(4.dp))
                Button(onClick = { onNavigateToDetails(book.id) }) {
                    Text("Détails")
                }
            }
        }
    }
}
