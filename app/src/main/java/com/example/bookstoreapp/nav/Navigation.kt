package com.example.bookstoreapp.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bookstoreapp.ui.products.ProductViewModel
import com.example.bookstoreapp.ui.products.screens.HomeScreen
import com.example.bookstoreapp.ui.products.views.ProductDetailsView

object Routes {
    const val Home = "home"
    const val ProductDetails = "productDetails"
}

@Composable
fun AppNavigation(viewModel: ProductViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Home) {

        composable(Routes.Home) {
            HomeScreen(viewModel, onNavigateToDetails = { bookId ->
                navController.navigate("${Routes.ProductDetails}/$bookId")
            })
        }

        composable(
            "${Routes.ProductDetails}/{bookId}",
            arguments = listOf(navArgument("bookId") { type = NavType.StringType })
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getString("bookId") ?: ""
            ProductDetailsView(bookId = bookId)
        }
    }
}
