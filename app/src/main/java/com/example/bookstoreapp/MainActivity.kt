package com.example.bookstoreapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import com.example.bookstoreapp.nav.AppNavigation
import com.example.bookstoreapp.ui.products.ProductViewModel
import com.example.bookstoreapp.ui.theme.BookstoreAppTheme

class MainActivity : ComponentActivity() {

    // ViewModel pour gérer la logique produit (MVI)
    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookstoreAppTheme {
                Surface {
                    // Lance la navigation principale avec le ViewModel
                    AppNavigation(viewModel = viewModel)
                }
            }
        }
    }
}
