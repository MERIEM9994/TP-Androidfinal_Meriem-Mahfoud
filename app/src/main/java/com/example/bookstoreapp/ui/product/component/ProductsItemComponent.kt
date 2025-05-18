package com.example.bookstoreapp.ui.product.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.bookstoreapp.data.Entities.Book

@Composable
fun ProductsItemComponent(
    book: Book,
    onDetailClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = "Titre: ${book.title}")
            Text(text = "Auteur: ${book.author}")
            Text(text = "Type: ${book.type.name}")
            Button(
                onClick = onDetailClick,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Voir détails")
            }
        }
    }
}